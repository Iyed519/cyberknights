package tn.coconsultbackend.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Indicator;
import tn.coconsultbackend.Model.Milestone;

public interface IndicatorRepository extends JpaRepository<Indicator,Long> {
}
