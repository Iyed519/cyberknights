package tn.coconsultbackend.HumanRessourcesProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.EmploymentEvaluation;

public interface EmploymentEvaluationRepository extends JpaRepository <EmploymentEvaluation, Long> {
}
