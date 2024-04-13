package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.FileCrudRepository;
import co.com.ufps.jpa.entities.FileEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.file.File;
import co.com.ufps.model.file.gateways.FileRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Base64;

@Primary
@Repository
public class FileRepositoryAdapter extends AdapterOperations<File, FileEntity, String,
        FileCrudRepository> implements FileRepository {

    public FileRepositoryAdapter(FileCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, File.class));
    }

    @Override
    public void save(String name, java.io.File file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(name);
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        fileEntity.setBase64(Base64.getEncoder().encodeToString(fileBytes));
        repository.save(fileEntity);
    }

    @Override
    public InputStream findByName(String name) {
        FileEntity fileEntity = repository.findByName(name);
        byte[] decodedBytes = Base64.getDecoder().decode(fileEntity.getBase64());
        return new ByteArrayInputStream(decodedBytes);
    }
}
