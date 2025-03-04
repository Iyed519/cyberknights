package tn.coconsultbackend.FinanceAndAccountingProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.BalanceSheet;
import tn.coconsultbackend.Model.CashFlowStatement;

public interface CashFlowStatementRepository extends JpaRepository<CashFlowStatement,Long> {
    CashFlowStatement findByPeriod(String period);
}
