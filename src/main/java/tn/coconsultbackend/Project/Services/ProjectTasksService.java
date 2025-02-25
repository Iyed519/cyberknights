package tn.coconsultbackend.Project.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.Model.ProjectTasks;
import tn.coconsultbackend.Project.Repositories.ProjectTasksRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProjectTasksService implements IProjectTasks {
    @Autowired
    private ProjectTasksRepository projectTasksRepository;

    public List<ProjectTasks> getAllProjectTasks() {
        return projectTasksRepository.findAll();
    }

    public Optional<ProjectTasks> getProjectTasksById(Long id) {
        return projectTasksRepository.findById(id);
    }

    public ProjectTasks saveProjectTasks(ProjectTasks projectTasks) {
        return projectTasksRepository.save(projectTasks);
    }

    public void deleteProjectTasks(Long id) {
        projectTasksRepository.deleteById(id);
    }
}
