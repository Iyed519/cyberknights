package tn.coconsultbackend.Project.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.Model.PerformanceReport;
import tn.coconsultbackend.Project.Repositories.PerformanceReportRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PerformanceReportService implements IPerformanceReport{
    @Autowired
    private PerformanceReportRepository performanceReportRepository;

    @Override
    public List<PerformanceReport> getAllPerformanceReports() {
        return performanceReportRepository.findAll();
    }

    @Override
    public Optional<PerformanceReport> getPerformanceReportById(Long id) {
        return performanceReportRepository.findById(id);
    }

    @Override
    public PerformanceReport savePerformanceReport(PerformanceReport performanceReport) {
        return performanceReportRepository.save(performanceReport);
    }

    @Override
    public void deletePerformanceReport(Long id) {
        performanceReportRepository.deleteById(id);
    }
}
