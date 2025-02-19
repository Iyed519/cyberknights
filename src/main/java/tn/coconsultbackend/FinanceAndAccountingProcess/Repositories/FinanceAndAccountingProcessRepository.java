package tn.coconsultbackend.FinanceAndAccountingProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Process;

public interface FinanceAndAccountingProcessRepository extends JpaRepository<Process,Long> {
}
