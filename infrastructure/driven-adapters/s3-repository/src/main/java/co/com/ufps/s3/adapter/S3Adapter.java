package co.com.ufps.s3.adapter;

import co.com.ufps.model.file.gateways.FileRepository;
import co.com.ufps.s3.config.model.S3ConnectionProperties;
import co.com.ufps.s3.operations.S3Operations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.InputStream;

@Repository
@RequiredArgsConstructor
public class S3Adapter implements FileRepository {

    private final S3Operations s3Operations;
    private final S3ConnectionProperties properties;


    @Override
    public void save(String name, File file) {
        s3Operations.uploadObject(properties.getBucketName(), name, file);
    }

    @Override
    public InputStream findByName(String name) {
        return s3Operations.getObject(properties.getBucketName(), name);
    }
}
