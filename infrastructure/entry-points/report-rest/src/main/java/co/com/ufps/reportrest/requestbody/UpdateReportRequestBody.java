package co.com.ufps.reportrest.requestbody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateReportRequestBody {
    private Long id;
    private String observations;
    private String state;
}
