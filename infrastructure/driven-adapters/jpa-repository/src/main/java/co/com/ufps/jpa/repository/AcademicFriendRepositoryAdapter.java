package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.AcademicFriendCrudRepository;
import co.com.ufps.jpa.entities.AcademicFriendEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.academicfriend.gateways.AcademicFriendRepository;
import co.com.ufps.model.consultancy.Consultancy;
import co.com.ufps.model.consultancy.gateways.ConsultancyRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Repository
public class AcademicFriendRepositoryAdapter extends AdapterOperations<AcademicFriend, AcademicFriendEntity, String,
        AcademicFriendCrudRepository>
        implements AcademicFriendRepository {

    @Autowired
    private ConsultancyRepository consultancyRepository;

    public AcademicFriendRepositoryAdapter(AcademicFriendCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, AcademicFriend.class));
    }

    @Override
    @Transactional
    public AcademicFriend apply(AcademicFriend academicFriend) {
        log.info("apply: {}", academicFriend.getEmail());

        List<Consultancy> consultanciesReceived = academicFriend.getConsultanciesReceived();
        academicFriend.setConsultanciesReceived(null);

        AcademicFriendEntity academicFriendEntity = mapper.map(academicFriend, AcademicFriendEntity.class);
        AcademicFriend academicFriendSaved = mapper.map(repository.save(academicFriendEntity), AcademicFriend.class);

        consultancyRepository.save(consultanciesReceived);

        academicFriendSaved.setConsultanciesReceived(consultanciesReceived);
        return academicFriendSaved;
    }

    @Override
    @Transactional
    public AcademicFriend update(AcademicFriend academicFriend) {
        log.info("update: {}", academicFriend.getEmail());
        AcademicFriendEntity academicFriendEntity = mapper.map(academicFriend, AcademicFriendEntity.class);
        return mapper.map(repository.save(academicFriendEntity), AcademicFriend.class);
    }

    @Override
    public List<AcademicFriend> findAll() {
        log.info("findAll");
        Iterable<AcademicFriendEntity> academicFriendEntities = repository.findAll();
        List<AcademicFriend> academicFriends = new ArrayList<>();
        for (AcademicFriendEntity academicFriendEntity : academicFriendEntities) {
            academicFriends.add(mapper.map(academicFriendEntity, AcademicFriend.class));
        }
        return academicFriends;
    }

    @Override
    public AcademicFriend findByEmail(String email) {
        log.info("findByEmail: {}", email);
        Optional<AcademicFriendEntity> academicFriendEntity = repository.findById(email);
        if (academicFriendEntity.isPresent()) {
            return mapper.map(academicFriendEntity.get(), AcademicFriend.class);
        }
        return null;
    }

    @Override
    public List<AcademicFriend> findByConvocation(Long id) {
        log.info("findByConvocation: {}", id);
        Iterable<AcademicFriendEntity> academicFriendEntities = repository.findByConvocation(id);
        List<AcademicFriend> academicFriends = new ArrayList<>();
        for (AcademicFriendEntity academicFriendEntity : academicFriendEntities) {
            academicFriends.add(mapper.map(academicFriendEntity, AcademicFriend.class));
        }
        return academicFriends;
    }

    @Override
    public AcademicFriend findByCode(String code) {
        log.info("findByCode: {}", code);
        Optional<AcademicFriendEntity> academicFriendEntity = repository.findByCode(code);
        if (academicFriendEntity.isPresent()) {
            return mapper.map(academicFriendEntity.get(), AcademicFriend.class);
        }
        return null;
    }
}
