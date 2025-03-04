package tn.coconsultbackend.TrainingManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.TrainingManagement.Entities.TrainingSession;

import java.util.Optional;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Long> {
//    TrainingSession findByTrainer_Id(Long trainerId);
//    Optional<TrainingSession> findById(Long id);
//    TrainingSession findByTrainee_Id(Long traineeId);
}
