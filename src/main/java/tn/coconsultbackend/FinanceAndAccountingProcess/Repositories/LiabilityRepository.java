package tn.coconsultbackend.FinanceAndAccountingProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.Model.Liability;
@Repository
public interface LiabilityRepository extends JpaRepository<Liability,Long> {
}
