package co.com.ufps.schedulerest.responsebody;

import co.com.ufps.model.schedule.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ScheduleResponseBody {

    private int numberOfHours;
    private List<DayResponseBody> days;

    public ScheduleResponseBody() {
        this.numberOfHours = 0;
        this.days = new ArrayList<>();
    }

    public static ScheduleResponseBody of(List<Schedule> schedules) {
        ScheduleResponseBody response = new ScheduleResponseBody();
        for (Schedule schedule : schedules) {
            response.addSchedule(schedule);
        }
        return response;
    }

    public void addSchedule(Schedule schedule) {
        if (containsDay(schedule.getDay())) {
            getDay(schedule.getDay()).addSchedule(schedule);
        } else {
            this.days.add(new DayResponseBody(schedule));
        }
        addHour();
    }

    public int addHour() {
        return ++this.numberOfHours;
    }

    public boolean containsDay(DayOfWeek day) {
        return getDay(day) != null;
    }

    public DayResponseBody getDay(DayOfWeek day) {
        for (DayResponseBody d : this.days) {
            if (d.getDay().equals(day)) {
                return d;
            }
        }
        return null;
    }
}
