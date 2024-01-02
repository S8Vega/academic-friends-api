package co.com.ufps.reportrest.responsebody;

import co.com.ufps.model.report.Report;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReportResponseBody {
    private Long id;
    private String academicFriendEmail;
    private String type;
    private String observations;
    private String state;
    private String date;
    private String uploadDate;
    private String file;

    public static ReportResponseBody of(Report report) {
        ReportResponseBody reportResponseBody = new ReportResponseBody();
        reportResponseBody.setId(report.getId());
        reportResponseBody.setAcademicFriendEmail(report.getAcademicFriend().getEmail());
        reportResponseBody.setType(report.getType());
        reportResponseBody.setObservations(report.getObservations());
        reportResponseBody.setState(report.getState());
        reportResponseBody.setDate(report.getDate().toString());
        reportResponseBody.setUploadDate(report.getUploadDate().toString());
        reportResponseBody.setFile(report.getFile());
        return reportResponseBody;
    }

    public static List<ReportResponseBody> of(List<Report> reports) {
        return reports.stream().map(ReportResponseBody::of).toList();
    }
}
