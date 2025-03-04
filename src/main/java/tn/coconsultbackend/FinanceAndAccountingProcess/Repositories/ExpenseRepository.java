package tn.coconsultbackend.FinanceAndAccountingProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Asset;
import tn.coconsultbackend.Model.Expense;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    Expense findByIdExpense(long idExpense);
    List<Expense> findByPeriod(String period);
}
