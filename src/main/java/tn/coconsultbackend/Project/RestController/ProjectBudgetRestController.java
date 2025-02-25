package tn.coconsultbackend.Project.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.Model.ProjectBudget;
import tn.coconsultbackend.Project.Services.IProjectBudget;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/project-budgets")
public class ProjectBudgetRestController {
    @Autowired
    private IProjectBudget projectBudgetService;

    @GetMapping
    public List<ProjectBudget> getAllProjectBudgets() {
        return projectBudgetService.getAllProjectBudgets();
    }

    @GetMapping("/{id}")
    public Optional<ProjectBudget> getProjectBudgetById(@PathVariable Long id) {
        return projectBudgetService.getProjectBudgetById(id);
    }

    @PostMapping
    public ProjectBudget createProjectBudget(@RequestBody ProjectBudget projectBudget) {
        return projectBudgetService.saveProjectBudget(projectBudget);
    }

    @PutMapping("/{id}")
    public ProjectBudget updateProjectBudget(@PathVariable Long id, @RequestBody ProjectBudget projectBudget) {
        projectBudget.setIdProjectBudget(id);
        return projectBudgetService.saveProjectBudget(projectBudget);
    }

    @DeleteMapping("/{id}")
    public void deleteProjectBudget(@PathVariable Long id) {
        projectBudgetService.deleteProjectBudget(id);
    }
}
