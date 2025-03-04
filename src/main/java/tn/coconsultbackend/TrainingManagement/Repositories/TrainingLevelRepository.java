package tn.coconsultbackend.TrainingManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.TrainingManagement.Entities.TrainingLevel;

public interface TrainingLevelRepository extends JpaRepository<TrainingLevel, Long> {
  /*  TrainingLevel findByName(String name);
    TrainingLevel findById(long id);
    TrainingLevel findByTraining_Name(String name);
    TrainingLevel findByTraining_Id(long id);
    TrainingLevel findByTrainingLevelId(long id);*/
}
