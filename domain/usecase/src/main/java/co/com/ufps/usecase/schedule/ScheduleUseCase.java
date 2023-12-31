package co.com.ufps.usecase.schedule;

import co.com.ufps.model.schedule.Schedule;
import co.com.ufps.model.schedule.gateways.ScheduleRepository;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

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

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public Schedule findById(Long id) {
        return scheduleRepository.findById(id);
    }

    public Schedule update(Long id, String status) {
        if (!Schedule.Constants.STATUSES.contains(status)) {
            throw new IllegalArgumentException("Invalid status");
        }
        Schedule schedule = scheduleRepository.findById(id);
        schedule.setStatus(status);
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> findByAcademicFriend(String academicFriendEmail) {
        return scheduleRepository.findByAcademicFriend(academicFriendEmail);
    }
}
