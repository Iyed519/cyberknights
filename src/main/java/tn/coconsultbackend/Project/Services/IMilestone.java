package tn.coconsultbackend.Project.Services;

import tn.coconsultbackend.Model.Milestone;

import java.util.List;
import java.util.Optional;

public interface IMilestone{
    List<Milestone> getAllMilestones();
    Optional<Milestone> getMilestoneById(Long id);
    Milestone saveMilestone(Milestone milestone);
    void deleteMilestone(Long id);

}
