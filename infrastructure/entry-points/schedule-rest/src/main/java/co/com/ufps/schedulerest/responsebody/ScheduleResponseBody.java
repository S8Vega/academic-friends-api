package co.com.ufps.schedulerest.responsebody;

import co.com.ufps.model.schedule.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleResponseBody {
    private Long id;
    private String academicFriendEmail;
    private String day;
    private String startTime;
    private String endTime;
    private String status;

    public static ScheduleResponseBody of(Schedule schedule) {
        ScheduleResponseBody scheduleResponseBody = new ScheduleResponseBody();
        scheduleResponseBody.setId(schedule.getId());
        scheduleResponseBody.setAcademicFriendEmail(schedule.getAcademicFriend().getEmail());
        scheduleResponseBody.setDay(schedule.getDay().name());
        scheduleResponseBody.setStartTime(schedule.getStartTime().toString());
        scheduleResponseBody.setEndTime(schedule.getEndTime().toString());
        scheduleResponseBody.setStatus(schedule.getStatus());
        return scheduleResponseBody;
    }

    public static List<ScheduleResponseBody> of(List<Schedule> schedules) {
        return schedules.stream().map(ScheduleResponseBody::of).toList();
    }
}
