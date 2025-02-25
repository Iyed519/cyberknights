package tn.coconsultbackend.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.ProjectTasks;

public interface ProjectTasksRepository extends JpaRepository<ProjectTasks,Long> {
}
