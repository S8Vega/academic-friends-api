package co.com.ufps.userrest.requestbody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResetPasswordRequestBody {
    private String email;
    private String password;
}
