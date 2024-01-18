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
    private static final int MAX_HOURS_PER_DAY = 4;
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
        int hoursPerDay = getHoursPerDay(academicFriendEmail, dayOfWeek);
        while (hour.isBefore(end)) {
            Schedule schedule = findByDayAndHour(dayOfWeek, hour);
            if (schedule == null) {
                log.info(String.format("the schedule for the day %s and hour %s does not exist", day, hour));
                hour = hour.plusHours(1);
                continue;
            }
            if (schedule.containsAcademicFriend(academicFriend)) {
                log.info(String.format("the academic friend %s is already in the schedule for the day %s and hour %s",
                        academicFriendEmail, day, hour));
                hour = hour.plusHours(1);
                continue;
            }
            if (hoursPerDay >= MAX_HOURS_PER_DAY) {
                throw new IllegalArgumentException(String.format("the academic friend %s has already %d hours in the day %s",
                        academicFriendEmail, MAX_HOURS_PER_DAY, day));
            }
            schedule.addAcademicFriend(academicFriend);
            schedule.cleanAcademicFriends();
            scheduleRepository.save(schedule);
            hoursPerDay++;
            hour = hour.plusHours(1);
        }
    }

    private int getHoursPerDay(String academicFriendEmail, DayOfWeek day) {
        List<Schedule> schedules = findByAcademicFriend(academicFriendEmail);
        int count = 0;
        for (Schedule schedule : schedules) {
            if (schedule.getDay().equals(day)) {
                count++;
            }
        }
        return count;
    }

    public Schedule findByDayAndHour(DayOfWeek day, LocalTime hour) {
        return scheduleRepository.findByDayAndHour(day, hour);
    }

    public void removeAcademicFriend(String academicFriendEmail, String day, String startHour, String endHour) {
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
            if (!schedule.containsAcademicFriend(academicFriend)) {
                log.info(String.format("the academic friend %s is not in the schedule for the day %s and hour %s",
                        academicFriendEmail, day, hour));
                hour = hour.plusHours(1);
                continue;
            }
            schedule.removeAcademicFriend(academicFriend);
            schedule.cleanAcademicFriends();
            scheduleRepository.save(schedule);
            hour = hour.plusHours(1);
        }
    }
}
