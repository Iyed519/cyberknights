package tn.coconsultbackend.QualityManagementProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.NonConformance;

public interface NonConformanceRepo extends JpaRepository<NonConformance, Long> {
}
