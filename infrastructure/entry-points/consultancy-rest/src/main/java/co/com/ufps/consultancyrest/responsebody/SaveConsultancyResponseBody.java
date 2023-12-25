package co.com.ufps.consultancyrest.responsebody;

import co.com.ufps.model.consultancy.Consultancy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveConsultancyResponseBody {
    private String academicFriendEmail;
    private String studentCode;
    private String courseName;
    private String startDate;
    private String endDate;
    private String difficultiesEncountered;
    private String aspectsToImprove;

    public static SaveConsultancyResponseBody from(Consultancy consultancy) {
        SaveConsultancyResponseBody responseBody = new SaveConsultancyResponseBody();
        responseBody.setAcademicFriendEmail(consultancy.getAcademicFriend().getEmail());
        responseBody.setStudentCode(consultancy.getStudent().getCode());
        responseBody.setCourseName(consultancy.getCourse().getName());
        responseBody.setStartDate(consultancy.getStartDate().toString());
        responseBody.setEndDate(consultancy.getEndDate().toString());
        responseBody.setDifficultiesEncountered(consultancy.getDifficultiesEncountered());
        responseBody.setAspectsToImprove(consultancy.getAspectsToImprove());
        return responseBody;
    }
}
