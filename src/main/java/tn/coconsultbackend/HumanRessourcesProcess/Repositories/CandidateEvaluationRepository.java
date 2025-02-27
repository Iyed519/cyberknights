package tn.coconsultbackend.HumanRessourcesProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.CandidateEvaluation;

public interface CandidateEvaluationRepository extends JpaRepository<CandidateEvaluation, Long> {
}
