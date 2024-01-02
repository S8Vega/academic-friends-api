package co.com.ufps.usecase.schedule;

import co.com.ufps.model.schedule.Schedule;
import co.com.ufps.model.schedule.gateways.ScheduleRepository;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@RequiredArgsConstructor
public class ScheduleUseCase {
    private final ScheduleRepository scheduleRepository;
    private final AcademicFriendUseCase academicFriendUseCase;

    public Schedule save(String academicFriendEmail, String day, String startTime, String endTime) {
        Schedule schedule = new Schedule();
        schedule.setAcademicFriend(academicFriendUseCase.findByEmail(academicFriendEmail));
        schedule.setDay(DayOfWeek.valueOf(day));
        schedule.setStartTime(LocalTime.parse(startTime));
        schedule.setEndTime(LocalTime.parse(endTime));
        schedule.setStatus(Schedule.Constants.STATUS_PENDING);
        return scheduleRepository.save(schedule);
    }
}
