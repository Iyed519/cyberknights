package tn.coconsultbackend.FinanceAndAccountingProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Asset;
import tn.coconsultbackend.Model.Revenue;

import java.util.List;

public interface RevenueRepository extends JpaRepository<Revenue,Long> {
    Revenue findByIdRevenue(long id);
    List<Revenue> findByPeriod(String period);
}
