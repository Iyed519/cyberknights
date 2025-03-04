package tn.coconsultbackend.TrainingManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.TrainingManagement.Entities.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
