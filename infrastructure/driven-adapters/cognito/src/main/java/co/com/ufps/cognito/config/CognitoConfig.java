package co.com.ufps.cognito.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;

@Configuration
@RequiredArgsConstructor
public class CognitoConfig {
    @Value("${aws_access_key_id}")
    private String awsAccessKeyId;
    @Value("${aws_secret_access_key}")
    private String awsSecretAccessKey;

    public AwsBasicCredentials awsCredentials() {
        return AwsBasicCredentials.create(awsAccessKeyId, awsSecretAccessKey);
    }

    @Bean
    public CognitoIdentityProviderClient cognitoIdentityProviderClient() {
        return CognitoIdentityProviderClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials()))
                .region(Region.US_EAST_1)
                .build();
    }
}
