package co.com.ufps.schedulerest.responsebody;

import co.com.ufps.model.schedule.Schedule;
import co.com.ufps.model.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class HourResponseBody {
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hour;
    private String classroom;
    private List<String> academicFriends;

    public HourResponseBody(Schedule schedule) {
        this.hour = schedule.getHour();
        this.classroom = schedule.getClassroom();
        this.academicFriends = new ArrayList<>();
        this.academicFriends.addAll(schedule.getAcademicFriends().stream().map(User::getEmail).toList());
    }

    public void addSchedule(Schedule schedule) {
        this.academicFriends.addAll(schedule.getAcademicFriends().stream().map(User::getEmail).toList());
    }
}
