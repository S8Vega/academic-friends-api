package co.com.ufps.model.schedule.gateways;

import co.com.ufps.model.schedule.Schedule;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);
}
