package tn.coconsultbackend.FinanceAndAccountingProcess.RestController;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.FinanceAndAccountingProcess.Services.IFinanceAndAccountingProcessService;
import tn.coconsultbackend.Model.Asset;
import tn.coconsultbackend.Model.Liability;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/finance")
@CrossOrigin(origins = "http://localhost:4200")  //
public class FinanceAndAccountingProcessRestController {
    @Autowired
    private IFinanceAndAccountingProcessService service;

//    //Liability
//    @PostMapping("addLiability")
//    Liability addLiability(@RequestBody Liability liability) {
//        return service.addLiability(liability);
//    }
//    @PostMapping("addLiabilities")
//    List<Liability> addLiabilities (@RequestBody List<Liability> liabilities){
//        return service.addLiabilities(liabilities);
//    }
//    @PutMapping("updateLiability")
//    Liability updateLiability (@RequestBody Liability liability){
//        return service.updateLiability(liability);
//    }
//    @PutMapping("updateLiabilities")
//    List<Liability> updateLiabilities (@RequestBody List<Liability> liabilities){
//        return service.updateLiabilities(liabilities);}
//    @DeleteMapping("deleteLiability")
//    void deleteLiability(@RequestBody Liability liability){
//        service.deleteLiability(liability);
//    }
//    @DeleteMapping("deleteAssetById")
//    void deleteLiabilityById(@RequestParam long id){
//        service.deleteLiabilityById(id);
//    }
//    @DeleteMapping("deleteAllLiability")
//    void deleteAllLiability(){
//        service.deleteAllLiability();
//    }
//    @DeleteMapping("deleteAllLiabilities")
//    void deleteAllLiabilities(@RequestBody List<Liability> liabilities){
//        service.deleteAllLiabilities(liabilities);
//    }
//    @GetMapping("findAllLiabilities")
//    List<Liability> findAllLiabilities(){
//        return service.findAllLiabilities();
//    }
//    @GetMapping("findLiabilityById")
//    Asset findByIdLiability(@RequestParam long id){
//        return service.findByIdAsset(id);
//    }



    //Asset

    @PostMapping("addAsset")
    Asset addAsset(@RequestBody Asset asset) {
        return service.addAsset(asset);
    }
    @PostMapping("addAssets")
    List<Asset> addAsset (@RequestBody List<Asset> assets){
        return service.addAsset(assets);
    }
    @PutMapping("updateAsset")
    Asset updateAsset (@RequestBody Asset asset){
        return service.updateAsset(asset);
    }
    @PutMapping("updateAssets")
    List<Asset> updateAsset (@RequestBody List<Asset> assets){
        return service.updateAsset(assets);}
    @DeleteMapping("deleteAsset")
    void deleteAsset(@RequestBody Asset asset){
        service.deleteAsset(asset);
    }
    @DeleteMapping("deleteAssetById")
    void deleteAssetById(@RequestParam long id){
        service.deleteAssetById(id);
    }
    @DeleteMapping("deleteAllAsset")
    void deleteAllAssets(){
        service.deleteAllAssets();
    }
    @DeleteMapping("deleteAllAssets")
    void deleteAllAssets(@RequestBody List<Asset> assets){
        service.deleteAllAssets(assets);
    }
    @GetMapping
    List<Asset> findAllAssets(){
        return service.findAllAssets();
    }
    @GetMapping("findAssetById")
    Asset findByIdAsset (@RequestParam long id){
        return service.findByIdAsset(id);
    }
}
