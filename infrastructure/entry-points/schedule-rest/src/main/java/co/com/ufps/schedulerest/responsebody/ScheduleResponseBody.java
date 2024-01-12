package co.com.ufps.schedulerest.responsebody;

import co.com.ufps.model.schedule.Schedule;
import co.com.ufps.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleResponseBody {
    private Long id;
    private List<String> academicFriendEmails;
    private String day;
    private String time;
    private String classroom;

    public static ScheduleResponseBody of(Schedule schedule) {
        ScheduleResponseBody scheduleResponseBody = new ScheduleResponseBody();
        scheduleResponseBody.setId(schedule.getId());
        scheduleResponseBody.setAcademicFriendEmails(schedule.getAcademicFriends().stream()
                .map(User::getEmail).toList());
        scheduleResponseBody.setDay(schedule.getDay().name());
        scheduleResponseBody.setTime(schedule.getHour().toString());
        scheduleResponseBody.setClassroom(schedule.getClassroom());
        return scheduleResponseBody;
    }

    public static List<ScheduleResponseBody> of(List<Schedule> schedules) {
        return schedules.stream().map(ScheduleResponseBody::of).toList();
    }
}
