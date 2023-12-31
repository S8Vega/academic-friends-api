package co.com.ufps.convocationrest.responsebody;

import co.com.ufps.model.convocation.Convocation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
public class ConvocationResponseBody {
    private Long id;
    private String openingDate;
    private String closingDate;
    private String evaluationDate;
    private String resultsReleaseDate;

    public static ConvocationResponseBody from(Convocation convocation) {
        return ConvocationResponseBody.builder()
                .id(convocation.getId())
                .openingDate(convocation.getOpeningDate().toString())
                .closingDate(convocation.getClosingDate().toString())
                .evaluationDate(convocation.getEvaluationDate().toString())
                .resultsReleaseDate(convocation.getResultsReleaseDate().toString())
                .build();
    }

    public static List<ConvocationResponseBody> from(List<Convocation> convocations) {
        return convocations.stream()
                .map(ConvocationResponseBody::from)
                .toList();
    }
}
