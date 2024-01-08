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
    public int compareTo(Report other) {
        return Comparator.comparing(Report::getUploadDate).reversed().compare(this, other);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Report other) {
            return this.getId().equals(other.getId()) && this.getAcademicFriend().equals(other.getAcademicFriend())
                    && this.getType().equals(other.getType()) && this.getObservations().equals(other.getObservations())
                    && this.getState().equals(other.getState()) && this.getDate().equals(other.getDate())
                    && this.getUploadDate().equals(other.getUploadDate()) && this.getFile().equals(other.getFile());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode() + this.getAcademicFriend().hashCode() + this.getType().hashCode()
                + this.getObservations().hashCode() + this.getState().hashCode() + this.getDate().hashCode()
                + this.getUploadDate().hashCode() + this.getFile().hashCode();
    }

    public static class Constants {
        public static final String TYPE_MONTHLY = "monthly";
        public static final String TYPE_FINAL = "final";
        public static final List<String> TYPES = List.of(TYPE_MONTHLY, TYPE_FINAL);
        public static final String STATE_PASS = "pass";
        public static final String STATE_PENDING = "pending";
        public static final String STATE_WITH_CORRECTIONS = "withCorrections";
        public static final String STATE_REJECTED = "rejected";

        public static final List<String> STATES = List.of(STATE_PASS, STATE_PENDING, STATE_WITH_CORRECTIONS,
                STATE_REJECTED);

        private Constants() {
            throw new IllegalStateException("Utility class");
        }
    }
}
