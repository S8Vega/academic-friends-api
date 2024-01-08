package co.com.ufps.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String email;
    private String name;
    private String code;
    private String type;


    public class Constants {
        public static final String STUDENT = "student";
        public static final String ACADEMIC_FRIEND = "academicFriend";
        public static final String COORDINATOR = "coordinator";
        public static final String DIRECTOR = "director";
        public static final String EMAIL = "@ufps.edu.co";

        public static final List<String> TYPES = List.of(STUDENT, ACADEMIC_FRIEND, COORDINATOR, DIRECTOR);

        private Constants() {
            throw new IllegalStateException("Utility class");
        }
    }
}
