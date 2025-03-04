package tn.coconsultbackend.ProcessManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.Model.Operation;

@Repository
public interface OperationRepo extends JpaRepository<Operation, Long> {
}
