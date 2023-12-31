package co.com.ufps.cognito;

import co.com.ufps.model.exceptions.CognitoException;
import co.com.ufps.model.security.gateways.SecurityRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminCreateUserRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminCreateUserResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminSetUserPasswordRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminSetUserPasswordResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthFlowType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthenticationResultType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderException;
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.RespondToAuthChallengeResponse;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Repository
@RequiredArgsConstructor
@Log4j2
public class CognitoAdapter implements SecurityRepository {
    private final CognitoIdentityProviderClient cognitoClient;
    @Value("${cognito_client_id}")
    private String clientId;
    @Value("${secret_key}")
    private String secretKey;
    @Value("${cognito_user_pool_id}")
    private String userPoolId;

    @Override
    public String login(String email, String password, String role) throws IOException {
        log.info("Iniciando sesión con el usuario: {}", email);
        String accessToken = getAccessToken(email, password);
        if (accessToken.isEmpty()) {
            return "";
        }
        return generateToken(email, role);
    }

    private String getAccessToken(String email, String password) {
        try {
            Map<String, String> authParams = new HashMap<>();
            authParams.put("USERNAME", email);
            authParams.put("PASSWORD", password);

            InitiateAuthRequest authRequest = InitiateAuthRequest.builder()
                    .clientId(clientId)
                    .authFlow(AuthFlowType.USER_PASSWORD_AUTH)
                    .authParameters(authParams)
                    .build();
            InitiateAuthResponse initiateAuthResponse = cognitoClient.initiateAuth(authRequest);

            if (initiateAuthResponse.challengeName() != null) {
                log.info("El usuario {} debe cambiar su contraseña", email);
                authParams.put("NEW_PASSWORD", password);
                RespondToAuthChallengeRequest respondToAuthChallengeRequest = RespondToAuthChallengeRequest.builder()
                        .challengeName("NEW_PASSWORD_REQUIRED")
                        .clientId(clientId)
                        .challengeResponses(authParams)
                        .session(initiateAuthResponse.session())
                        .build();

                RespondToAuthChallengeResponse respondToAuthChallengeResponse = cognitoClient
                        .respondToAuthChallenge(respondToAuthChallengeRequest);
                return respondToAuthChallengeResponse.authenticationResult().accessToken();
            }

            AuthenticationResultType result = initiateAuthResponse.authenticationResult();
            return result.accessToken();
        } catch (CognitoIdentityProviderException e) {
            log.error("Error en el inicio de sesión");
            log.error(e.awsErrorDetails().errorMessage());
            throw new CognitoException(e);
        }
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
        log.info("Registrando usuario: {}", email);
        try {
            AdminCreateUserRequest createUserRequest = AdminCreateUserRequest.builder()
                    .userPoolId(userPoolId)
                    .username(email)
                    .temporaryPassword(password)
                    .userAttributes(AttributeType.builder().name("email").value(email).build(),
                            AttributeType.builder().name("email_verified").value("true").build(),
                            AttributeType.builder().name("custom:role").value(role).build())
                    .build();

            AdminCreateUserResponse createUserResponse = cognitoClient.adminCreateUser(createUserRequest);
            log.info("Usuario registrado: {}", createUserResponse.user().username());
        } catch (CognitoIdentityProviderException e) {
            log.error("Error en el registro de usuario");
            log.error(e.awsErrorDetails().errorMessage());
            throw new CognitoException(e);
        }
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
    public void resetPassword(String email, String password) throws IOException {
        log.info("Reseteando contraseña del usuario: {}", email);
        try {
            AdminSetUserPasswordRequest adminSetUserPasswordRequest = AdminSetUserPasswordRequest.builder()
                    .userPoolId(userPoolId)
                    .username(email)
                    .password(password)
                    .permanent(true)
                    .build();
            AdminSetUserPasswordResponse adminSetUserPasswordResponse = cognitoClient
                    .adminSetUserPassword(adminSetUserPasswordRequest);
            log.info("Contraseña reseteada del usuario: {}", email);
        } catch (CognitoIdentityProviderException e) {
            log.error("Error en el reseteo de contraseña");
            log.error(e.awsErrorDetails().errorMessage());
            throw new CognitoException(e);
        }
    }
}
