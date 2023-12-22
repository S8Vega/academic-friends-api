package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.ConvocationCrudRepository;
import co.com.ufps.jpa.entities.ConvocationEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.convocation.Convocation;
import co.com.ufps.model.convocation.gateways.ConvocationRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConvocationRepositoryAdapter extends AdapterOperations<Convocation, ConvocationEntity, Long, ConvocationCrudRepository>
        implements ConvocationRepository {

    public ConvocationRepositoryAdapter(ConvocationCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Convocation.class));
    }

    @Override
    public Convocation save(Convocation convocation) {
        ConvocationEntity convocationEntity = mapper.map(convocation, ConvocationEntity.class);
        return mapper.map(repository.save(convocationEntity), Convocation.class);
    }

    @Override
    public List<Convocation> findAll() {
        Iterable<ConvocationEntity> convocationEntities = repository.findAll();
        return List.of(mapper.map(convocationEntities, Convocation[].class));
    }

    @Override
    public Convocation findById(Long id) {
        ConvocationEntity convocationEntity = repository.findById(id).orElse(null);
        return mapper.map(convocationEntity, Convocation.class);
    }
}
