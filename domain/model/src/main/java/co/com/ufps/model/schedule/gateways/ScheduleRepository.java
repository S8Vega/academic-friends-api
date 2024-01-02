package co.com.ufps.model.schedule.gateways;

import co.com.ufps.model.schedule.Schedule;

import java.util.List;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);

    List<Schedule> findAll();
}
