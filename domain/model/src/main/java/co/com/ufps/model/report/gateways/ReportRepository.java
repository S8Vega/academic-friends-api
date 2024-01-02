package co.com.ufps.model.report.gateways;

import co.com.ufps.model.report.Report;

import java.util.List;

public interface ReportRepository {
    Report save(Report report);

    List<Report> findByAcademicFriend(String academicFriendEmail);
}
