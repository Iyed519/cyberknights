package tn.coconsultbackend.Project.Services;

import tn.coconsultbackend.Model.ProjectBudget;

import java.util.List;
import java.util.Optional;

public interface IProjectBudget {
    List<ProjectBudget> getAllProjectBudgets();
    Optional<ProjectBudget> getProjectBudgetById(Long id);
    ProjectBudget saveProjectBudget(ProjectBudget projectBudget);
    void deleteProjectBudget(Long id);
}
