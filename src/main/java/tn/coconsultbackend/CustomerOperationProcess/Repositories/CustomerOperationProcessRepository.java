package tn.coconsultbackend.CustomerOperationProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Process;

public interface CustomerOperationProcessRepository extends JpaRepository<Process, Long> {
}
