package tn.coconsultbackend.CustomerOperationProcess.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.Model.Contract;
import tn.coconsultbackend.Model.Document;

import java.util.List;
import java.util.Optional;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
void deleteById(Long id);



}
