package co.com.ufps.convocationrest.requestbody;

import co.com.ufps.model.convocation.Convocation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class SaveConvocationRequestBody {
    private String openingDate;
    private String closingDate;
    private String evaluationDate;
    private String resultsReleaseDate;

    public Convocation toConvocation() {
        Convocation convocation = new Convocation();
        convocation.setOpeningDate(LocalDateTime.parse(openingDate));
        convocation.setClosingDate(LocalDateTime.parse(closingDate));
        convocation.setEvaluationDate(LocalDateTime.parse(evaluationDate));
        convocation.setResultsReleaseDate(LocalDateTime.parse(resultsReleaseDate));
        return convocation;
    }
}
