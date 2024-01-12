package co.com.ufps.model.schedule.gateways;

import co.com.ufps.model.schedule.Schedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);

    List<Schedule> findAll();

    List<Schedule> findByAcademicFriend(String academicFriendEmail);

    Schedule findByDayAndHour(DayOfWeek day, LocalTime hour);
}
