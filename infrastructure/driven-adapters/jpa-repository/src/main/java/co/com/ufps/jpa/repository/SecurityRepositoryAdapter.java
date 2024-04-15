package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.SecurityCrudRepository;
import co.com.ufps.jpa.entities.SecurityEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.security.Security;
import co.com.ufps.model.security.gateways.SecurityRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.Key;
import java.security.SignatureException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@Primary
@Repository
public class SecurityRepositoryAdapter extends AdapterOperations<Security, SecurityEntity, String, SecurityCrudRepository>
        implements SecurityRepository {

    @Value("${secret_key}")
    private String secretKey;

    public SecurityRepositoryAdapter(SecurityCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Security.class));
    }

    @Override
    public String login(String email, String password, String role) throws IOException {
        Optional<Security> security = findByEmail(email);
        if (security.isEmpty() || !security.get().getPassword().equals(password)) {
            return "";
        }
        return generateToken(email, role);
    }

    @Override
    public void validate(String token) {
        Key key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), SignatureAlgorithm.HS256.getJcaName());
        Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }

    @Override
    public void save(String email, String password, String role) {
        Security security = new Security();
        security.setEmail(email);
        security.setPassword(password);
        security.setRole(role);
        repository.save(mapper.map(security, SecurityEntity.class));
    }

    @Override
    public String getTokenRole(String token) {
        Key key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), SignatureAlgorithm.HS256.getJcaName());
        String role = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
        return role == null ? "" : role;
    }

    @Override
    public void resetPassword(String email, String password) throws SignatureException {
        Optional<Security> security = findByEmail(email);
        if (security.isEmpty()) {
            throw new SignatureException("User not found");
        }
        Security securityModel = security.get();
        securityModel.setPassword(password);
        repository.save(mapper.map(securityModel, SecurityEntity.class));
    }

    @Override
    public void resetPassword(String email, String newPassword, String code) throws SignatureException {
        throw new SignatureException("Not implemented");
    }

    @Override
    public void forgotPassword(String email) throws SignatureException {
        throw new SignatureException("Not implemented");
    }

    @Override
    public void delete(String email) throws IOException {
        this.repository.deleteById(email);
    }

    private Optional<Security> findByEmail(String email) {
        SecurityEntity securityEntity = repository.findByEmail(email).orElse(null);
        return Optional.ofNullable(mapper.map(securityEntity, Security.class));
    }

    private String generateToken(String email, String role) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.DAYS)))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .claim("role", role)
                .compact();
    }
}
