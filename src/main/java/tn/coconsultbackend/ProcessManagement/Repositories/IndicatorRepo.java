package tn.coconsultbackend.ProcessManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.Model.Indicator;

@Repository
public interface IndicatorRepo extends JpaRepository<Indicator, Long> {
}
