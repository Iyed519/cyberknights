package tn.coconsultbackend.FinanceAndAccountingProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Asset;
import tn.coconsultbackend.Model.IncomeStatement;

public interface IncomeStatementRepository extends JpaRepository<IncomeStatement,Long> {
    IncomeStatement findByPeriod(String period);
}
