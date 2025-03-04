package tn.coconsultbackend.TrainingManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.TrainingManagement.Entities.Skill;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
//    Skill findByName(String name);
//    Skill findSkillById(long id);
//    List<Skill> findAllByTrainingTrainingLevelsTrainingSessionsTraineeId(long id);

}
