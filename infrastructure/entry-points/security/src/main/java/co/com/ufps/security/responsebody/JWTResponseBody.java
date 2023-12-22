package co.com.ufps.security.responsebody;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class JWTResponseBody {
    private String jwt;
}
