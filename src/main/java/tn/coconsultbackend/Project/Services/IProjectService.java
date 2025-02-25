package tn.coconsultbackend.Project.Services;

import tn.coconsultbackend.Model.Project;
import tn.coconsultbackend.Model.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {
    List<Project> getAllProjects();
    Optional<Project> getProjectById(Long id);
    Project saveProject(Project project);
    void deleteProject(Long id);
}
