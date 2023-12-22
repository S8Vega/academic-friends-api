package co.com.ufps.director.requestbody;

import co.com.ufps.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveDirectorRequestBody {
    private String email;
    private String password;
    private String name;
    private String code;

    public User toUser() {
        return User.builder()
                .email(email)
                .name(name)
                .code(code)
                .type("director")
                .build();
    }
}
