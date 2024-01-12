package co.com.ufps.schedulerest.requestbody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SaveScheduleRequestBody {
    private String classroom;
    private String day;
    private String startTime;
    private String endTime;
}
