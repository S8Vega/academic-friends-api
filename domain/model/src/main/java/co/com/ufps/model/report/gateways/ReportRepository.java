package co.com.ufps.model.report.gateways;

import co.com.ufps.model.report.Report;

public interface ReportRepository {
    Report save(Report report);
}
