package tn.coconsultbackend.TrainingManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import tn.coconsultbackend.TrainingManagement.Entities.Certification;

import java.time.LocalDate;
@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
   /* Certification findCertificationById(long id);
    Certification findAllCertificationByCertificationType(String certificationType);
    Certification findCertificationByIssueDate(LocalDate issueDate);
    Certification findCertificationByIssueDateAndCertificationType(LocalDate issueDate, String certificationType);
    Integer countCertificationByIssueDate(LocalDate issueDate);
    Integer countCertificationByCertificationType(String certificationType);
    Integer countAllCertification();*/


}
