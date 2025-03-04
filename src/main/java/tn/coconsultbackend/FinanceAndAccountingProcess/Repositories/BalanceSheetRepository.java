package tn.coconsultbackend.FinanceAndAccountingProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.Model.BalanceSheet;

@Repository
public interface BalanceSheetRepository extends JpaRepository<BalanceSheet,Long> {
    BalanceSheet findByPeriod(String period);
}
