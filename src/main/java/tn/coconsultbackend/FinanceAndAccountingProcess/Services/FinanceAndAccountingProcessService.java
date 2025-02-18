package tn.coconsultbackend.FinanceAndAccountingProcess.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.FinanceAndAccountingProcess.Repositories.AssetRepository;
import tn.coconsultbackend.FinanceAndAccountingProcess.Repositories.LiabilityRepository;
import tn.coconsultbackend.Model.Asset;
import tn.coconsultbackend.Model.Liability;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class FinanceAndAccountingProcessService implements IFinanceAndAccountingProcessService {
    @Autowired
    AssetRepository ar;
    @Autowired
    LiabilityRepository lr;

    //asset
    @Override
    public Asset addAsset(Asset asset) {
        return ar.save(asset);
    }

    @Override
    public List<Asset> addAsset(List<Asset> assets) {
        return ar.saveAll(assets);
    }

    @Override
    public Asset updateAsset(Asset asset) {
        return ar.save(asset);
    }

    @Override
    public List<Asset> updateAsset(List<Asset> assets) {
        return ar.saveAll(assets);
    }

    @Override
    public void deleteAsset(Asset asset) {
        ar.delete(asset);

    }

    @Override
    public void deleteAssetById(long id) {
        ar.deleteById(id);

    }

    @Override
    public void deleteAllAssets() {
        ar.deleteAll();

    }

    @Override
    public void deleteAllAssets(List<Asset> assets) {
        ar.deleteAll(assets);

    }

    @Override
    public List<Asset> findAllAssets() {
        return ar.findAll();
    }

    @Override
    public Asset findByIdAsset(long id) {
        return ar.findById(id).get();
    }

    @Override
    public long countAssets() {
        return ar.count();
    }

    @Override
    public boolean existByIdAsset(long id) {
        return ar.existsById(id);
    }


    //Liability

    @Override
    public Liability addLiability(Liability liability) {
        return lr.save(liability);
    }

    @Override
    public List<Liability> addLiabilities(List<Liability> liabilities) {
        return lr.saveAll(liabilities);
    }

    @Override
    public Liability updateLiability(Liability liability) {
        return lr.save(liability);
    }

    @Override
    public List<Liability> updateLiabilities(List<Liability> liabilities) {
        return lr.saveAll(liabilities);
    }

    @Override
    public void deleteLiability(Liability liability) {
        lr.delete(liability);

    }

    @Override
    public void deleteLiabilityById(long id) {
        lr.deleteById(id);

    }

    @Override
    public void deleteAllLiability() {
        lr.deleteAll();

    }

    @Override
    public void deleteAllLiabilities(List<Liability> Liabilities) {
        lr.deleteAll(Liabilities);

    }

    @Override
    public List<Liability> findAllLiabilities() {
        return lr.findAll();
    }

    @Override
    public Liability findByIdLiability(long id) {
        return lr.findById(id).get();
    }

    @Override
    public long countLiability() {
        return lr.count();
    }

    @Override
    public boolean existByIdLiability(long id) {
        return lr.existsById(id);
    }
}
