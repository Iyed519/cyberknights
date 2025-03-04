package tn.coconsultbackend.QualityManagementProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.CorrectiveActions;

public interface CorrectiveActionsRepo extends JpaRepository<CorrectiveActions, Long> {
}
