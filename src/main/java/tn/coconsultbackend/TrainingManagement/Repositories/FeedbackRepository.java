package tn.coconsultbackend.TrainingManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.TrainingManagement.Entities.Feedback;
import tn.coconsultbackend.TrainingManagement.Entities.Training;
import tn.coconsultbackend.TrainingManagement.Entities.TrainingSession;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
 /*   Feedback findFeedbackById(long id);

    Feedback findFeedbackByTraining(Training training);

    List<Feedback> findAllByTraining_TrainingLevels_TrainingSession_TrainingSession_Id(long trainingSessionId);*/
}
