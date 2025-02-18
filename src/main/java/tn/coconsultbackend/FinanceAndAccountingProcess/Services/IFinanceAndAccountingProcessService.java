package tn.coconsultbackend.FinanceAndAccountingProcess.Services;

import tn.coconsultbackend.Model.Asset;
import tn.coconsultbackend.Model.Liability;

import java.util.List;

public interface IFinanceAndAccountingProcessService {

    //asset
    Asset addAsset(Asset asset);
    List<Asset> addAsset(List<Asset> assets);
    Asset updateAsset (Asset asset);
    List<Asset> updateAsset (List<Asset> assets);
    void deleteAsset(Asset asset);
    void deleteAssetById(long id);
    void deleteAllAssets();
    void deleteAllAssets(List<Asset> assets);
    List<Asset> findAllAssets();
    Asset findByIdAsset (long id);
    long countAssets();
    boolean existByIdAsset(long id);


    //Liability
    Liability addLiability(Liability liability);
    List<Liability> addLiabilities(List<Liability> liabilities);
    Liability updateLiability (Liability liability);
    List<Liability> updateLiabilities (List<Liability> liabilities);
    void deleteLiability(Liability liability);
    void deleteLiabilityById(long id);
    void deleteAllLiability();
    void deleteAllLiabilities(List<Liability> Liabilities);
    List<Liability> findAllLiabilities();
    Liability findByIdLiability (long id);
    long countLiability();
    boolean existByIdLiability(long id);
}
