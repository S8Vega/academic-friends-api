package co.com.ufps.model.consultancy.gateways;

import co.com.ufps.model.consultancy.Consultancy;

public interface ConsultancyRepository {
    Consultancy save(Consultancy consultancy);
}
