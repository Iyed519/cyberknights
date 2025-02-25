package tn.coconsultbackend.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Project;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
