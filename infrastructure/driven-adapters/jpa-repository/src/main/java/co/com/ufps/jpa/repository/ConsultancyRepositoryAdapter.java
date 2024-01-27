package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.ConsultancyCrudRepository;
import co.com.ufps.jpa.entities.ConsultancyEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.consultancy.Consultancy;
import co.com.ufps.model.consultancy.gateways.ConsultancyRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Consultancy> save(List<Consultancy> consultancies) {
        List<Consultancy> consultanciesSaved = new ArrayList<>();
        for (Consultancy consultancy : consultancies) {
            consultanciesSaved.add(this.save(consultancy));
        }
        return consultanciesSaved;
    }

    @Override
    public List<Consultancy> findByStudent(String email) {
        List<ConsultancyEntity> entities = repository.findByStudent(email);
        List<Consultancy> consultancies = new ArrayList<>();
        for (ConsultancyEntity entity : entities) {
            consultancies.add(this.mapper.map(entity, Consultancy.class));
        }
        return consultancies;
    }

    @Override
    public List<Consultancy> findByAcademicFriend(String email) {
        List<ConsultancyEntity> entities = repository.findByAcademicFriend(email);
        List<Consultancy> consultancies = new ArrayList<>();
        for (ConsultancyEntity entity : entities) {
            consultancies.add(this.mapper.map(entity, Consultancy.class));
        }
        return consultancies;
    }

    @Override
    public List<Consultancy> findByStartDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        List<ConsultancyEntity> entities = repository.findByStartDateBetween(startDate, endDate);
        List<Consultancy> consultancies = new ArrayList<>();
        for (ConsultancyEntity entity : entities) {
            consultancies.add(this.mapper.map(entity, Consultancy.class));
        }
        return consultancies;
    }

    @Override
    public List<Consultancy> findByCourse(String name) {
        List<ConsultancyEntity> entities = repository.findByCourse(name);
        List<Consultancy> consultancies = new ArrayList<>();
        for (ConsultancyEntity entity : entities) {
            consultancies.add(this.mapper.map(entity, Consultancy.class));
        }
        return consultancies;
    }

    @Override
    public void delete(List<Consultancy> consultancies) {
        for (Consultancy consultancy : consultancies) {
            ConsultancyEntity entity = this.mapper.map(consultancy, ConsultancyEntity.class);
            repository.delete(entity);
        }
    }
}
