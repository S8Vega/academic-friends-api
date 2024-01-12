package co.com.ufps.consultancyrest.responsebody;

import co.com.ufps.model.consultancy.Consultancy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ConsultancyResponseBody {
    private String academicFriendEmail;
    private String studentCode;
    private String studentName;
    private String courseName;
    private String startDate;
    private String endDate;
    private String difficultiesEncountered;
    private String aspectsToImprove;

    public static ConsultancyResponseBody from(Consultancy consultancy) {
        ConsultancyResponseBody responseBody = new ConsultancyResponseBody();
        responseBody.setAcademicFriendEmail(consultancy.getAcademicFriend().getEmail());
        responseBody.setStudentCode(consultancy.getStudent().getCode());
        responseBody.setStudentName(consultancy.getStudent().getName());
        responseBody.setCourseName(consultancy.getCourse().getName());
        responseBody.setStartDate(consultancy.getStartDate().toString());
        responseBody.setEndDate(consultancy.getEndDate().toString());
        responseBody.setDifficultiesEncountered(consultancy.getDifficultiesEncountered());
        responseBody.setAspectsToImprove(consultancy.getAspectsToImprove());
        return responseBody;
    }

    public static List<ConsultancyResponseBody> from(List<Consultancy> consultancies) {
        return consultancies.stream().map(ConsultancyResponseBody::from).toList();
    }
}
