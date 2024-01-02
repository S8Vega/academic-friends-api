package co.com.ufps.schedulerest.requestbody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateScheduleRequestBody {
    private Long id;
    private String status;
}
