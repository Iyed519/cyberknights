package tn.coconsultbackend.Project.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.Model.PerformanceReport;
import tn.coconsultbackend.Project.Services.IPerformanceReport;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/performance-reports")
public class PerformanceReportRestController {
    @Autowired
    private IPerformanceReport performanceReportService;

    @GetMapping
    public List<PerformanceReport> getAllPerformanceReports() {
        return performanceReportService.getAllPerformanceReports();
    }

    @GetMapping("/{id}")
    public Optional<PerformanceReport> getPerformanceReportById(@PathVariable Long id) {
        return performanceReportService.getPerformanceReportById(id);
    }

    @PostMapping
    public PerformanceReport createPerformanceReport(@RequestBody PerformanceReport performanceReport) {
        return performanceReportService.savePerformanceReport(performanceReport);
    }

    @PutMapping("/{id}")
    public PerformanceReport updatePerformanceReport(@PathVariable Long id, @RequestBody PerformanceReport performanceReport) {
        performanceReport.setReportId(id);
        return performanceReportService.savePerformanceReport(performanceReport);
    }

    @DeleteMapping("/{id}")
    public void deletePerformanceReport(@PathVariable Long id) {
        performanceReportService.deletePerformanceReport(id);
    }
}
