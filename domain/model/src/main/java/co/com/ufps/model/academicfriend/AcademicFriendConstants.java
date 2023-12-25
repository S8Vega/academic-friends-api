package co.com.ufps.model.academicfriend;

import java.util.List;

public class AcademicFriendConstants {
    public class Status {
        public static final String PASS = "pass";
        public static final String PENDING = "pending";
        public static final String REJECTED = "rejected";
        public static final List<String> STATUS = List.of(PASS, PENDING, REJECTED);
    }
}
