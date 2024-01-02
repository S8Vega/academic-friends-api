package co.com.ufps.model.report;

import co.com.ufps.model.academicfriend.AcademicFriend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Report implements Comparable<Report> {
    private Long id;
    private AcademicFriend academicFriend;
    private String type;
    private String observations;
    private String state;
    private LocalDateTime date;
    private LocalDateTime uploadDate;
    private String file;

    @Override
    public int compareTo(Report o) {
        return Comparator.comparing(Report::getUploadDate).reversed().compare(this, o);
    }

    public class Constants {
        public static final String TYPE_MONTHLY = "monthly";
        public static final String TYPE_FINAL = "final";
        public static final List<String> TYPES = List.of(TYPE_MONTHLY, TYPE_FINAL);
        public static final String STATE_PASS = "pass";
        public static final String STATE_PENDING = "pending";
        public static final String STATE_WITH_CORRECTIONS = "withCorrections";
        public static final String STATE_REJECTED = "rejected";

        public static final List<String> STATES = List.of(STATE_PASS, STATE_PENDING, STATE_WITH_CORRECTIONS,
                STATE_REJECTED);
    }
}
