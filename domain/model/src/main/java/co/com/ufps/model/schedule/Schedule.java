package co.com.ufps.model.schedule;

import co.com.ufps.model.academicfriend.AcademicFriend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Schedule implements Comparable<Schedule> {
    private Long id;
    private List<AcademicFriend> academicFriends;
    private DayOfWeek day;
    private LocalTime hour;
    private String classroom;

    public void cleanAcademicFriends() {
        for (AcademicFriend academicFriend : academicFriends) {
            academicFriend.cleanConvocation();
        }
    }

    public void addAcademicFriend(AcademicFriend academicFriend) {
        if (academicFriends == null) {
            academicFriends = new ArrayList<>();
        }
        academicFriends.add(academicFriend);
    }

    public void removeAcademicFriend(AcademicFriend academicFriend) {
        if (academicFriends == null) {
            academicFriends = new ArrayList<>();
        }
        academicFriends.removeIf(af -> af.getEmail().equals(academicFriend.getEmail()));
    }

    public boolean containsAcademicFriend(AcademicFriend academicFriend) {
        if (academicFriends == null) {
            academicFriends = new ArrayList<>();
        }
        return academicFriends.stream().anyMatch(af -> af.getEmail().equals(academicFriend.getEmail()));
    }

    @Override
    public int compareTo(Schedule o) {
        return this.day.compareTo(o.day) == 0 ? this.hour.compareTo(o.hour) : this.day.compareTo(o.day);
    }
}
