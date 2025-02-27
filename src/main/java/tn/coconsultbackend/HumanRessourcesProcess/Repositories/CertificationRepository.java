package tn.coconsultbackend.HumanRessourcesProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Certification;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
