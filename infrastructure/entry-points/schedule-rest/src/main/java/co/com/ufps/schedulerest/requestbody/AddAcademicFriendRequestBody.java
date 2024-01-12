package co.com.ufps.schedulerest.requestbody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddAcademicFriendRequestBody {
    private String academicFriendEmail;
    private String day;
    private String startHour;
    private String endHour;
}
