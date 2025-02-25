package tn.coconsultbackend.Project.Services;

import tn.coconsultbackend.Model.PerformanceReport;

import java.util.List;
import java.util.Optional;

public interface IPerformanceReport {
    List<PerformanceReport> getAllPerformanceReports();
    Optional<PerformanceReport> getPerformanceReportById(Long id);
    PerformanceReport savePerformanceReport(PerformanceReport performanceReport);
    void deletePerformanceReport(Long id);
}
