package tn.coconsultbackend.FinanceAndAccountingProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.Model.Liability;

import java.util.List;

@Repository
public interface LiabilityRepository extends JpaRepository<Liability,Long> {

    Liability findByIdLiability(Long liabilityId);

    List<Liability> findAllByPeriod(String period);
}
