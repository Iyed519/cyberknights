package tn.coconsultbackend.Project.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.Model.Milestone;
import tn.coconsultbackend.Project.Services.IMilestone;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/milestones")
public class MilestoneRestController {
    @Autowired
    private IMilestone milestoneService;

    @GetMapping
    public List<Milestone> getAllMilestones() {
        return milestoneService.getAllMilestones();
    }

    @GetMapping("/{id}")
    public Optional<Milestone> getMilestoneById(@PathVariable Long id) {
        return milestoneService.getMilestoneById(id);
    }

    @PostMapping
    public Milestone createMilestone(@RequestBody Milestone milestone) {
        return milestoneService.saveMilestone(milestone);
    }

    @PutMapping("/{id}")
    public Milestone updateMilestone(@PathVariable Long id, @RequestBody Milestone milestone) {
        milestone.setMilestoneId(id);
        return milestoneService.saveMilestone(milestone);
    }

    @DeleteMapping("/{id}")
    public void deleteMilestone(@PathVariable Long id) {
        milestoneService.deleteMilestone(id);
    }
}
