package co.com.ufps.usecase.schedule;

import co.com.ufps.model.schedule.Schedule;
import co.com.ufps.model.schedule.gateways.ScheduleRepository;
import co.com.ufps.usecase.TestBuilder;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ScheduleUseCaseTest {
    @InjectMocks
    private ScheduleUseCase scheduleUseCase;
    @Mock
    private ScheduleRepository scheduleRepository;
    @Mock
    private AcademicFriendUseCase academicFriendUseCase;

    @Test
    void save() {
        Schedule schedule = TestBuilder.schedule();
        schedule.setAcademicFriend(TestBuilder.academicFriend());
        when(academicFriendUseCase.findByEmail(anyString())).thenReturn(schedule.getAcademicFriend());
        when(scheduleRepository.save(any(Schedule.class))).thenReturn(schedule);

        Schedule response = scheduleUseCase.save(schedule.getAcademicFriend().getEmail(), schedule.getDay().toString(),
                schedule.getStartTime().toString(), schedule.getEndTime().toString());

        assertEquals(schedule, response);
        verify(academicFriendUseCase).findByEmail(anyString());
        verify(scheduleRepository).save(any(Schedule.class));
    }

    @Test
    void findAll() {
        Schedule schedule = TestBuilder.schedule();
        when(scheduleRepository.findAll()).thenReturn(List.of(schedule));

        List<Schedule> response = scheduleUseCase.findAll();

        assertEquals(List.of(schedule), response);
        verify(scheduleRepository).findAll();
    }

    @Test
    void findById() {
        Schedule schedule = TestBuilder.schedule();
        when(scheduleRepository.findById(schedule.getId())).thenReturn(schedule);

        Schedule response = scheduleUseCase.findById(schedule.getId());

        assertEquals(schedule, response);
        verify(scheduleRepository).findById(any(Long.class));
    }

    @Test
    void update() {
        Schedule schedule = TestBuilder.schedule();
        when(scheduleRepository.findById(schedule.getId())).thenReturn(schedule);
        when(scheduleRepository.save(any(Schedule.class))).thenReturn(schedule);

        Schedule response = scheduleUseCase.update(schedule.getId(), schedule.getStatus());

        assertEquals(schedule, response);
        verify(scheduleRepository).findById(any(Long.class));
        verify(scheduleRepository).save(any(Schedule.class));
    }

    @Test
    void findByAcademicFriend() {
        Schedule schedule = TestBuilder.schedule();
        schedule.setAcademicFriend(TestBuilder.academicFriend());
        when(scheduleRepository.findByAcademicFriend(schedule.getAcademicFriend().getEmail())).thenReturn(List.of(schedule));

        List<Schedule> response = scheduleUseCase.findByAcademicFriend(schedule.getAcademicFriend().getEmail());

        assertEquals(List.of(schedule), response);
        verify(scheduleRepository).findByAcademicFriend(anyString());
    }
}