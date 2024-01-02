package co.com.ufps.schedulerest.requestbody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveScheduleRequestBody {
    private String academicFriendEmail;
    private String day;
    private String startTime;
    private String endTime;
}
