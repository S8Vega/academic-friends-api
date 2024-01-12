package co.com.ufps.schedulerest.responsebody;

import co.com.ufps.model.schedule.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DayResponseBody {
    private DayOfWeek day;
    private List<HourResponseBody> hours;

    public DayResponseBody(Schedule schedule) {
        this.day = schedule.getDay();
        this.hours = new ArrayList<>();
        this.hours.add(new HourResponseBody(schedule));
    }

    public void addSchedule(Schedule schedule) {
        if (containsHour(schedule.getHour())) {
            getHour(schedule.getHour()).addSchedule(schedule);
        } else {
            this.hours.add(new HourResponseBody(schedule));
        }
    }

    public boolean containsHour(LocalTime hour) {
        return getHour(hour) != null;
    }

    public HourResponseBody getHour(LocalTime hour) {
        for (HourResponseBody h : this.hours) {
            if (h.getHour().equals(hour)) {
                return h;
            }
        }
        return null;
    }
}
