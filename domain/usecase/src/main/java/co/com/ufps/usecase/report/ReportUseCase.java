package co.com.ufps.usecase.report;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.report.Report;
import co.com.ufps.model.report.gateways.ReportRepository;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import co.com.ufps.usecase.file.FileUseCase;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class ReportUseCase {
    private static final String REPORT_FOLDER = "report";
    private final ReportRepository reportRepository;
    private final AcademicFriendUseCase academicFriendUseCase;
    private final FileUseCase fileUseCase;

    public Report save(String academicFriendEmail, String type, String date, File file) {
        Report report = new Report();
        AcademicFriend academicFriend = academicFriendUseCase.findByEmail(academicFriendEmail);
        report.setAcademicFriend(academicFriend);
        if (!Report.Constants.TYPES.contains(type)) {
            throw new RuntimeException("Invalid type");
        }
        report.setType(type);
        report.setState(Report.Constants.STATE_PENDING);
        report.setDate(LocalDateTime.parse(date));
        report.setUploadDate(LocalDateTime.now());
        report.setFile(String.format("%s/%s.%s", REPORT_FOLDER, UUID.randomUUID(), "pdf"));
        fileUseCase.save(report.getFile(), file);
        return reportRepository.save(report);
    }
}