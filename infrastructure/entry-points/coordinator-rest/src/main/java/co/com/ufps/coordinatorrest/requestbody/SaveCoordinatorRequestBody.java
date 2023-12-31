package co.com.ufps.coordinatorrest.requestbody;

import co.com.ufps.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveCoordinatorRequestBody {
    private String email;
    private String password;
    private String name;
    private String code;

    public User toUser() {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setCode(code);
        user.setType(User.Constants.COORDINATOR);
        return user;
    }
}
