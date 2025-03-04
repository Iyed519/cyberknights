package tn.coconsultbackend.TrainingManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.TrainingManagement.Entities.Training;

import java.util.List;
@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    Training findTrainingById(long id);
//    Training findTrainingByName(String name);
//    List<Training> findAllTrainings();
//    List<Training> findAllBySkills_Id(long id);
//    List<Training> findAllBySkills_Name(String name);
//    List<Training> findAllByTrainingLevels_TrainingSessions_Trainer_Id(long id);
}
