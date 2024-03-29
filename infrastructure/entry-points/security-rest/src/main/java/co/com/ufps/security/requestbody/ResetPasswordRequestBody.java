package co.com.ufps.security.requestbody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequestBody {
    private String email;
    private String password;
    private String code;
}
