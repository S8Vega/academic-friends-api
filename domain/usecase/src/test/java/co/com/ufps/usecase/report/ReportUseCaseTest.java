package co.com.ufps.usecase.report;

import co.com.ufps.model.report.Report;
import co.com.ufps.model.report.gateways.ReportRepository;
import co.com.ufps.usecase.TestBuilder;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import co.com.ufps.usecase.file.FileUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportUseCaseTest {
    @InjectMocks
    private ReportUseCase reportUseCase;
    @Mock
    private ReportRepository reportRepository;
    @Mock
    private AcademicFriendUseCase academicFriendUseCase;
    @Mock
    private FileUseCase fileUseCase;

    @Test
    void save() throws IOException {
        Report report = TestBuilder.report();
        report.setAcademicFriend(TestBuilder.academicFriend());
        File file = mock(File.class);
        when(academicFriendUseCase.findByEmail(report.getAcademicFriend().getEmail()))
                .thenReturn(report.getAcademicFriend());
        when(reportRepository.save(any(Report.class))).thenReturn(report);

        Report response = reportUseCase.save(report.getAcademicFriend().getEmail(), report.getType(),
                report.getDate().toString(), file);

        assertEquals(report, response);
        verify(academicFriendUseCase).findByEmail(report.getAcademicFriend().getEmail());
        verify(reportRepository).save(any(Report.class));
    }

    @Test
    void findByAcademicFriend() {
        Report report = TestBuilder.report();
        report.setAcademicFriend(TestBuilder.academicFriend());
        when(reportRepository.findByAcademicFriend(report.getAcademicFriend().getEmail()))
                .thenReturn(List.of(report));

        List<Report> response = reportUseCase.findByAcademicFriend(report.getAcademicFriend().getEmail());

        assertEquals(List.of(report), response);
        verify(reportRepository).findByAcademicFriend(report.getAcademicFriend().getEmail());
    }

    @Test
    void findById() {
        Report report = TestBuilder.report();
        when(reportRepository.findById(report.getId())).thenReturn(report);

        Report response = reportUseCase.findById(report.getId());

        assertEquals(report, response);
        verify(reportRepository).findById(report.getId());
    }

    @Test
    void update() {
        Report report = TestBuilder.report();
        when(reportRepository.save(any(Report.class))).thenReturn(report);
        when(reportRepository.findById(report.getId())).thenReturn(report);

        Report response = reportUseCase.update(report.getId(), report.getObservations(), report.getState());

        assertEquals(report, response);
        verify(reportRepository).save(any(Report.class));
    }

    @Test
    void testUpdate() throws IOException {
        Report report = TestBuilder.report();
        File file = mock(File.class);
        when(reportRepository.save(any(Report.class))).thenReturn(report);
        when(reportRepository.findById(report.getId())).thenReturn(report);

        Report response = reportUseCase.update(report.getId(), file);

        assertEquals(report, response);
        verify(reportRepository).save(any(Report.class));
    }

    @Test
    void findAll() {
        Report report = TestBuilder.report();
        when(reportRepository.findAll()).thenReturn(List.of(report));

        List<Report> response = reportUseCase.findAll();

        assertEquals(List.of(report), response);
        verify(reportRepository).findAll();
    }
}