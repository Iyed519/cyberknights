package tn.coconsultbackend.TrainingManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.TrainingManagement.Entities.Evaluation;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
 /*   Evaluation findEvaluationByEvaluationId(Long evaluationId);
    Evaluation findEvaluationByEvaluationName(String evaluationName);
    List<Evaluation> findAllByEvaluationNameContains(String evaluationName);
    List<Evaluation> findAllByEvaluationScore(Float evaluationScore);
    List<Evaluation> findAllByEvaluationScoreGreaterThan(Float evaluationScore);
    List<Evaluation> findAllByEvaluationScoreLessThan(Float evaluationScore);
    List<Evaluation> findAllByEvaluationScoreBetween(Float evaluationScore1, Float evaluationScore2);
    List<Evaluation> findAllByIsEvaluationValidated(Boolean isEvaluationValidated);
*/
}
