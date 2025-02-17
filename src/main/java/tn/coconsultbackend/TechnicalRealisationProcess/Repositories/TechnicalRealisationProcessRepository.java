package tn.coconsultbackend.TechnicalRealisationProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Process;

public interface TechnicalRealisationProcessRepository extends JpaRepository<Process,Long> {
}
