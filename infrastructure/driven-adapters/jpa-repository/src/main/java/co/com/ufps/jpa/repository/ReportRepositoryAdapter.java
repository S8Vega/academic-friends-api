package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.ReportCrudRepository;
import co.com.ufps.jpa.entities.ReportEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.report.Report;
import co.com.ufps.model.report.gateways.ReportRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepositoryAdapter extends AdapterOperations<Report, ReportEntity, Long,
        ReportCrudRepository>
        implements ReportRepository {

    public ReportRepositoryAdapter(ReportCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Report.class));
    }

    @Override
    public Report save(Report report) {
        ReportEntity entity = this.mapper.map(report, ReportEntity.class);
        return mapper.map(repository.save(entity), Report.class);
    }

}
