package co.com.ufps.usecase.report;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.report.Report;
import co.com.ufps.model.report.gateways.ReportRepository;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import co.com.ufps.usecase.file.FileUseCase;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
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
            throw new IllegalArgumentException("Invalid type");
        }
        report.setType(type);
        report.setState(Report.Constants.STATE_PENDING);
        report.setDate(LocalDateTime.parse(date));
        report.setUploadDate(LocalDateTime.now());
        report.setFile(String.format("%s/%s.%s", REPORT_FOLDER, UUID.randomUUID(), "pdf"));
        fileUseCase.save(report.getFile(), file);
        return reportRepository.save(report);
    }

    public List<Report> findByAcademicFriend(String academicFriendEmail) {
        return reportRepository.findByAcademicFriend(academicFriendEmail).stream().sorted().toList();
    }

    public Report findById(Long id) {
        return reportRepository.findById(id);
    }

    public Report update(Long id, String observations, String state) {
        Report report = findById(id);
        report.setObservations(observations);
        if (!Report.Constants.STATES.contains(state)) {
            throw new IllegalArgumentException("Invalid state");
        }
        report.setState(state);
        return reportRepository.save(report);
    }

    public Report update(Long id, File file) {
        Report report = findById(id);
        report.setUploadDate(LocalDateTime.now());
        fileUseCase.save(report.getFile(), file);
        return reportRepository.save(report);
    }

    public List<Report> findAll() {
        return reportRepository.findAll().stream().sorted().toList();
    }
}
