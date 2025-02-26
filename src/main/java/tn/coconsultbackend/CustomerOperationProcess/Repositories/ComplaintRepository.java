package tn.coconsultbackend.CustomerOperationProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Complaint;

import java.util.List;
import java.util.Optional;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByContractId(Long contractId);
    void deleteById(Long id);
}

