package co.com.ufps.model.consultancy.gateways;

import co.com.ufps.model.consultancy.Consultancy;

import java.util.List;

public interface ConsultancyRepository {
    Consultancy save(Consultancy consultancy);

    List<Consultancy> findByStudent(String email);

    List<Consultancy> findByAcademicFriend(String email);
}
