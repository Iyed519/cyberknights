package tn.coconsultbackend.QualityManagementProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Audit;

public interface AuditRepo extends JpaRepository<Audit, Long> {
}
