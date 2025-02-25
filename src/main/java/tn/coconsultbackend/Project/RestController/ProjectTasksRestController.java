package tn.coconsultbackend.Project.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.Model.ProjectTasks;
import tn.coconsultbackend.Project.Services.IProjectTasks;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class ProjectTasksRestController {
    @Autowired
    private IProjectTasks projectTasksService;

    @GetMapping
    public List<ProjectTasks> getAllProjectTasks() {
        return projectTasksService.getAllProjectTasks();
    }

    @GetMapping("/{id}")
    public Optional<ProjectTasks> getProjectTasksById(@PathVariable Long id) {
        return projectTasksService.getProjectTasksById(id);
    }

    @PostMapping
    public ProjectTasks createProjectTasks(@RequestBody ProjectTasks projectTasks) {
        return projectTasksService.saveProjectTasks(projectTasks);
    }

    @PutMapping("/{id}")
    public ProjectTasks updateProjectTasks(@PathVariable Long id, @RequestBody ProjectTasks projectTasks) {
        projectTasks.setIdProjectTasks(id);
        return projectTasksService.saveProjectTasks(projectTasks);
    }

    @DeleteMapping("/{id}")
    public void deleteProjectTasks(@PathVariable Long id) {
        projectTasksService.deleteProjectTasks(id);
    }
}
