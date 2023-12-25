package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.ConsultancyCrudRepository;
import co.com.ufps.jpa.entities.ConsultancyEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.consultancy.Consultancy;
import co.com.ufps.model.consultancy.gateways.ConsultancyRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultancyRepositoryAdapter extends AdapterOperations<Consultancy, ConsultancyEntity, Long,
        ConsultancyCrudRepository>
        implements ConsultancyRepository {

    public ConsultancyRepositoryAdapter(ConsultancyCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Consultancy.class));
    }

    @Override
    public Consultancy save(Consultancy consultancy) {
        ConsultancyEntity entity = this.mapper.map(consultancy, ConsultancyEntity.class);
        return this.mapper.map(repository.save(entity), Consultancy.class);
    }
}
