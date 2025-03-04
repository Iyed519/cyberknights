package tn.coconsultbackend.TrainingManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.TrainingManagement.Entities.Trainee;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
}
