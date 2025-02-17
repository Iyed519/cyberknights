package tn.coconsultbackend.DesignAndDevProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Process;

public interface DesignAndDevProcessRepository extends JpaRepository<Process,Long> {
}
