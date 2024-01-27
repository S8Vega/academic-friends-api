package co.com.ufps.model.consultancy.gateways;

import co.com.ufps.model.consultancy.Consultancy;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultancyRepository {
    Consultancy save(Consultancy consultancy);

    List<Consultancy> save(List<Consultancy> consultancies);

    List<Consultancy> findByStudent(String email);

    List<Consultancy> findByAcademicFriend(String email);

    List<Consultancy> findByStartDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Consultancy> findByCourse(String name);

    void delete(List<Consultancy> consultancies);
}
