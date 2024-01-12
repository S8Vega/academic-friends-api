package co.com.ufps.usecase.schedule;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.schedule.Schedule;
import co.com.ufps.model.schedule.gateways.ScheduleRepository;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Log
@RequiredArgsConstructor
public class ScheduleUseCase {
    private final ScheduleRepository scheduleRepository;
    private final AcademicFriendUseCase academicFriendUseCase;

    public void save(String classroom, String day, String startTime, String endTime) {
        LocalTime hour = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(day);
        while (hour.isBefore(end)) {
            Schedule schedule = findByDayAndHour(dayOfWeek, hour);
            if (schedule == null) {
                scheduleRepository.save(Schedule.builder()
                        .classroom(classroom)
                        .day(dayOfWeek)
                        .hour(hour)
                        .academicFriends(new ArrayList<>())
                        .build());
            } else {
                schedule.setClassroom(classroom);
                scheduleRepository.save(schedule);
            }
            hour = hour.plusHours(1);
        }
    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> findByAcademicFriend(String academicFriendEmail) {
        return scheduleRepository.findByAcademicFriend(academicFriendEmail);
    }

    public void addAcademicFriend(String academicFriendEmail, String day, String startHour, String endHour) {
        AcademicFriend academicFriend = academicFriendUseCase.findByEmail(academicFriendEmail);
        if (academicFriend == null) {
            throw new IllegalArgumentException("the academic friend does not exist");
        }
        LocalTime hour = LocalTime.parse(startHour);
        LocalTime end = LocalTime.parse(endHour);
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(day);
        while (hour.isBefore(end)) {
            Schedule schedule = findByDayAndHour(dayOfWeek, hour);
            if (schedule == null) {
                log.info(String.format("the schedule for the day %s and hour %s does not exist", day, hour));
                hour = hour.plusHours(1);
                continue;
            }
            schedule.addAcademicFriend(academicFriend);
            schedule.cleanAcademicFriends();
            scheduleRepository.save(schedule);
            hour = hour.plusHours(1);
        }
    }

    public Schedule findByDayAndHour(DayOfWeek day, LocalTime hour) {
        return scheduleRepository.findByDayAndHour(day, hour);
    }
}
