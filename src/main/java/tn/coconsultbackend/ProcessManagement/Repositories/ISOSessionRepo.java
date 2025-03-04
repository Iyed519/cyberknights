package tn.coconsultbackend.ProcessManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.Model.ISOSession;

@Repository
public interface ISOSessionRepo extends JpaRepository<ISOSession, Long> {
}
