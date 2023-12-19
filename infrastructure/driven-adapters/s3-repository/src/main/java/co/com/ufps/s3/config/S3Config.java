package co.com.ufps.s3.config;

import co.com.ufps.s3.config.model.S3ConnectionProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.auth.credentials.WebIdentityTokenFileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Configuration
public class S3Config {

    @Profile({"dev", "cer", "pdn"})
    @Bean
    public S3Client s3Client(S3ConnectionProperties s3Properties) {
        return S3Client.builder()
                .credentialsProvider(WebIdentityTokenFileCredentialsProvider.create())
                .region(Region.of(s3Properties.getRegion()))
                .build();
    }

    @Profile("local")
    @Bean
    public S3Client localS3Client(S3ConnectionProperties s3Properties) {
        return S3Client.builder()
                .region(Region.of(s3Properties.getRegion()))
                .credentialsProvider(ProfileCredentialsProvider.create("default"))
                .endpointOverride(URI.create(s3Properties.getEndpoint()))
                .build();
    }

}
