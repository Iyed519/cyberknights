package tn.coconsultbackend.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone,Long> {
}
