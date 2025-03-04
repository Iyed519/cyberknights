package tn.coconsultbackend.TrainingManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.TrainingManagement.Entities.TrainingContent;

import java.util.List;

public interface TrainingContentRepository extends JpaRepository<TrainingContent, Long> {

//    TrainingContent findTrainingContentById(long id);
//    TrainingContent findTrainingContentByTrainingId(long id);
//    List<TrainingContent> findByTrainingId(long id);
//    List<TrainingContent> findByTrainingLevel_Id(long id);
//    List<TrainingContent> findByTrainingLevel_Training_Id(long id);
}
