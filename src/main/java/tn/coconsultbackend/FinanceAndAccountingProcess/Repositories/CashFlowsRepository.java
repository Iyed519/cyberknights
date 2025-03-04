package tn.coconsultbackend.FinanceAndAccountingProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.BalanceSheet;
import tn.coconsultbackend.Model.CashFlows;
import tn.coconsultbackend.Model.TypeFlows;

public interface CashFlowsRepository extends JpaRepository<CashFlows,Long> {
    CashFlows findByIdCashFlows(long idcashflows);
    CashFlows findByType(TypeFlows type);
}
