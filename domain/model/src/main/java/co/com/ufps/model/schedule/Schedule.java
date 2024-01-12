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
public class Schedule {
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
}
