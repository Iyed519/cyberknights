package tn.coconsultbackend.Project.Services;

import tn.coconsultbackend.Model.ProjectTasks;

import java.util.List;
import java.util.Optional;

public interface IProjectTasks {
    List<ProjectTasks> getAllProjectTasks();
    Optional<ProjectTasks> getProjectTasksById(Long id);
    ProjectTasks saveProjectTasks(ProjectTasks projectTasks);
    void deleteProjectTasks(Long id);
}
