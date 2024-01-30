package co.com.ufps.model.convocation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Convocation {
    private Long id;
    private LocalDateTime openingDate;
    private LocalDateTime closingDate;
    private LocalDateTime evaluationDate;
    private LocalDateTime resultsReleaseDate;

    public boolean isValid() {
        return openingDate != null && closingDate != null && evaluationDate != null && resultsReleaseDate != null &&
                openingDate.isBefore(closingDate) && closingDate.isBefore(evaluationDate) &&
                evaluationDate.isBefore(resultsReleaseDate);
    }
}
