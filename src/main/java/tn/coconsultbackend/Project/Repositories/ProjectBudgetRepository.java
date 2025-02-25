package tn.coconsultbackend.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.ProjectBudget;

public interface ProjectBudgetRepository extends JpaRepository<ProjectBudget,Long> {
}
