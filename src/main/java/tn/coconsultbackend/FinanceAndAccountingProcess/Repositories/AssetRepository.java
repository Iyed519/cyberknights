package tn.coconsultbackend.FinanceAndAccountingProcess.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.coconsultbackend.Model.Asset;
import tn.coconsultbackend.Model.Process;
@Repository
public interface AssetRepository extends JpaRepository<Asset,Long> {
}
