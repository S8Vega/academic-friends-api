package co.com.ufps.model.schedule;

import co.com.ufps.model.academicfriend.AcademicFriend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Schedule {
    private Long id;
    private AcademicFriend academicFriend;
    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;

    public class Constants {
        public static final String STATUS_PASS = "pass";
        public static final String STATUS_PENDING = "pending";
        public static final String STATUS_REJECTED = "rejected";

        public static final List<String> STATUSES = List.of(STATUS_PASS, STATUS_PENDING, STATUS_REJECTED);

        private Constants() {
            throw new IllegalStateException("Utility class");
        }
    }
}
