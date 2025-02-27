package tn.coconsultbackend.HumanRessourcesProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.OperationTask;

public interface OperationTaskRepository extends JpaRepository<OperationTask, Long> {
}
