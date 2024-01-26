package co.com.ufps.usecase.schedule;

import co.com.ufps.model.academicfriend.AcademicFriend;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        schedule.addAcademicFriend(TestBuilder.academicFriend());
        when(scheduleRepository.save(any(Schedule.class))).thenReturn(schedule);

        scheduleUseCase.save(schedule.getClassroom(), schedule.getDay().toString(), schedule.getHour().toString(),
                schedule.getHour().plusHours(1).toString());

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
    void findByAcademicFriend() {
        Schedule schedule = TestBuilder.schedule();
        schedule.addAcademicFriend(TestBuilder.academicFriend());
        when(scheduleRepository.findByAcademicFriend(anyString())).thenReturn(List.of(schedule));

        List<Schedule> response = scheduleUseCase.findByAcademicFriend(schedule.getAcademicFriends().get(0).getEmail());

        assertEquals(List.of(schedule), response);
        verify(scheduleRepository).findByAcademicFriend(anyString());
    }

    @Test
    void addAcademicFriend() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Schedule schedule = TestBuilder.schedule();
        when(academicFriendUseCase.findByEmail(anyString())).thenReturn(academicFriend);
        when(scheduleRepository.findByDayAndHour(any(), any())).thenReturn(schedule);
        when(scheduleRepository.save(any(Schedule.class))).thenReturn(schedule);

        scheduleUseCase.addAcademicFriend(academicFriend.getEmail(), schedule.getDay().toString(),
                schedule.getHour().toString(), schedule.getHour().plusHours(1).toString());

        verify(academicFriendUseCase).findByEmail(anyString());
        verify(scheduleRepository).findByDayAndHour(any(), any());
        verify(scheduleRepository).save(any(Schedule.class));
    }

    @Test
    void removeAcademicFriend() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Schedule schedule = TestBuilder.schedule();
        schedule.addAcademicFriend(academicFriend);
        when(academicFriendUseCase.findByEmail(anyString())).thenReturn(academicFriend);
        when(scheduleRepository.findByDayAndHour(any(), any())).thenReturn(schedule);
        when(scheduleRepository.save(any(Schedule.class))).thenReturn(schedule);

        scheduleUseCase.removeAcademicFriend(academicFriend.getEmail(), schedule.getDay().toString(),
                schedule.getHour().toString(), schedule.getHour().plusHours(1).toString());

        verify(academicFriendUseCase).findByEmail(anyString());
        verify(scheduleRepository).findByDayAndHour(any(), any());
        verify(scheduleRepository).save(any(Schedule.class));
    }

    @Test
    void addAcademicFriendWithScheduleNull() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Schedule schedule = TestBuilder.schedule();
        when(academicFriendUseCase.findByEmail(anyString())).thenReturn(academicFriend);
        when(scheduleRepository.findByDayAndHour(any(), any())).thenReturn(null);

        scheduleUseCase.addAcademicFriend(academicFriend.getEmail(), schedule.getDay().toString(),
                schedule.getHour().toString(), schedule.getHour().plusHours(1).toString());

        verify(academicFriendUseCase).findByEmail(anyString());
        verify(scheduleRepository).findByDayAndHour(any(), any());
    }

    @Test
    void addAcademicFriendWithAcademicFriendOnSchedule() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Schedule schedule = TestBuilder.schedule();
        schedule.addAcademicFriend(academicFriend);
        when(academicFriendUseCase.findByEmail(anyString())).thenReturn(academicFriend);
        when(scheduleRepository.findByDayAndHour(any(), any())).thenReturn(schedule);

        scheduleUseCase.addAcademicFriend(academicFriend.getEmail(), schedule.getDay().toString(),
                schedule.getHour().toString(), schedule.getHour().plusHours(1).toString());

        verify(academicFriendUseCase).findByEmail(anyString());
        verify(scheduleRepository).findByDayAndHour(any(), any());
    }

    @Test
    void addAcademicFriendWithMaxHoursPerDay() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Schedule schedule = TestBuilder.schedule();
        when(academicFriendUseCase.findByEmail(anyString())).thenReturn(academicFriend);
        when(scheduleRepository.findByDayAndHour(any(), any())).thenReturn(schedule);
        when(scheduleRepository.findByAcademicFriend(anyString()))
                .thenReturn(List.of(schedule, schedule, schedule, schedule));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            scheduleUseCase.addAcademicFriend(academicFriend.getEmail(), schedule.getDay().toString(),
                    schedule.getHour().toString(), schedule.getHour().plusHours(1).toString());
        });

        assertEquals("El amigo academico sebas@test.com supera la cantidad de horas diaras permitidas," +
                " ya tiene 4 horas el dia lunes", exception.getMessage());
        verify(academicFriendUseCase).findByEmail(anyString());
        verify(scheduleRepository).findByDayAndHour(any(), any());
        verify(scheduleRepository).findByAcademicFriend(anyString());
    }

    @Test
    void removeAcademicFriendWithAcademicFriendNull() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Schedule schedule = TestBuilder.schedule();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            scheduleUseCase.removeAcademicFriend(academicFriend.getEmail(), schedule.getDay().toString(),
                    schedule.getHour().toString(), schedule.getHour().plusHours(1).toString());
        });

        assertEquals("El amigo academico no existe", exception.getMessage());
    }

    @Test
    void removeAcademicFriendWithScheduleNull() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Schedule schedule = TestBuilder.schedule();
        when(academicFriendUseCase.findByEmail(anyString())).thenReturn(academicFriend);
        when(scheduleRepository.findByDayAndHour(any(), any())).thenReturn(null);

        scheduleUseCase.removeAcademicFriend(academicFriend.getEmail(), schedule.getDay().toString(),
                schedule.getHour().toString(), schedule.getHour().plusHours(1).toString());

        verify(academicFriendUseCase).findByEmail(anyString());
        verify(scheduleRepository).findByDayAndHour(any(), any());
    }

    @Test
    void removeAcademicFriendWithAcademicFriendNotOnSchedule() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Schedule schedule = TestBuilder.schedule();
        when(academicFriendUseCase.findByEmail(anyString())).thenReturn(academicFriend);
        when(scheduleRepository.findByDayAndHour(any(), any())).thenReturn(schedule);

        scheduleUseCase.removeAcademicFriend(academicFriend.getEmail(), schedule.getDay().toString(),
                schedule.getHour().toString(), schedule.getHour().plusHours(1).toString());

        verify(academicFriendUseCase).findByEmail(anyString());
        verify(scheduleRepository).findByDayAndHour(any(), any());
    }
}