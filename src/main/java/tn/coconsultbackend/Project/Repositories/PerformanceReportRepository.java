package tn.coconsultbackend.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.PerformanceReport;
import tn.coconsultbackend.Model.Project;

public interface PerformanceReportRepository extends JpaRepository<PerformanceReport,Long> {
}
