package tn.coconsultbackend.QualityManagementProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.NonConformanceReport;

public interface NonConformanceReportRepo extends JpaRepository<NonConformanceReport, Long> {
}
