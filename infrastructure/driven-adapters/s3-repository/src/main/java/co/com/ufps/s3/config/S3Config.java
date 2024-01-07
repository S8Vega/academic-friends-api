package co.com.ufps.s3.config;

import co.com.ufps.s3.config.model.S3ConnectionProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {
    @Value("${aws_access_key_id}")
    private String awsAccessKeyId;
    @Value("${aws_secret_access_key}")
    private String awsSecretAccessKey;

    public AwsBasicCredentials awsCredentials() {
        return AwsBasicCredentials.create(awsAccessKeyId, awsSecretAccessKey);
    }

    @Bean
    public S3Client localS3Client(S3ConnectionProperties s3Properties) {
        return S3Client.builder()
                .region(Region.of(s3Properties.getRegion()))
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials()))
                .build();
    }
}
