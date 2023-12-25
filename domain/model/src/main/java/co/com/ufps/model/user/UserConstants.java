package co.com.ufps.model.user;

import java.util.List;

public class UserConstants {

    public class Type {
        public static final String STUDENT = "student";
        public static final String ACADEMIC_FRIEND = "academicFriend";
        public static final String COORDINATOR = "coordinator";
        public static final String DIRECTOR = "director";
        public static final List<String> TYPES = List.of(STUDENT, ACADEMIC_FRIEND, COORDINATOR, DIRECTOR);
    }

}
