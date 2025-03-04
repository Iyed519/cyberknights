package tn.coconsultbackend.ProcessManagement.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.Model.Process;

@Repository
public interface ProcessRepo extends JpaRepository<Process, Long> {
}
