package tn.coconsultbackend.Project.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.Model.Milestone;
import tn.coconsultbackend.Project.Repositories.MilestoneRepository;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Slf4j
public class MilestoneService implements IMilestone{
    @Autowired
    private MilestoneRepository milestoneRepository;

    @Override
    public List<Milestone> getAllMilestones() {
        return milestoneRepository.findAll();
    }

    @Override
    public Optional<Milestone> getMilestoneById(Long id) {
        return milestoneRepository.findById(id);
    }

    @Override
    public Milestone saveMilestone(Milestone milestone) {
        return milestoneRepository.save(milestone);
    }

    @Override
    public void deleteMilestone(Long id) {
        milestoneRepository.deleteById(id);
    }
}
