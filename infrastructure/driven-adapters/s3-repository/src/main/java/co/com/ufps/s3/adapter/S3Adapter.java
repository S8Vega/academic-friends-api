package co.com.ufps.s3.adapter;

import co.com.ufps.s3.config.model.S3ConnectionProperties;
import co.com.ufps.s3.operations.S3Operations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class S3Adapter /* implements Gateway from domain*/ {

    private final S3Operations s3Operations;

    private final S3ConnectionProperties properties;

}
