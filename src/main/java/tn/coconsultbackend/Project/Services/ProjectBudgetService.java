package tn.coconsultbackend.Project.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.Model.ProjectBudget;
import tn.coconsultbackend.Project.Repositories.ProjectBudgetRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProjectBudgetService implements IProjectBudget {
    @Autowired
    private ProjectBudgetRepository projectBudgetRepository;

    @Override
    public List<ProjectBudget> getAllProjectBudgets() {
        return projectBudgetRepository.findAll();
    }

    @Override
    public Optional<ProjectBudget> getProjectBudgetById(Long id) {
        return projectBudgetRepository.findById(id);
    }

    @Override
    public ProjectBudget saveProjectBudget(ProjectBudget projectBudget) {
        return projectBudgetRepository.save(projectBudget);
    }

    @Override
    public void deleteProjectBudget(Long id) {
        projectBudgetRepository.deleteById(id);
    }
}
