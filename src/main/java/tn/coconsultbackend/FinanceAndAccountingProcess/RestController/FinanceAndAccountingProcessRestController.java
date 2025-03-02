package tn.coconsultbackend.FinanceAndAccountingProcess.RestController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.FinanceAndAccountingProcess.Services.IFinanceAndAccountingProcessService;
import tn.coconsultbackend.Model.Asset;
import tn.coconsultbackend.Model.Liability;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RestControllerAdvice
@RequestMapping("/api/finance")
@CrossOrigin(origins = "http://localhost:4200")  //
public class FinanceAndAccountingProcessRestController {
    @Autowired
    private IFinanceAndAccountingProcessService service;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    //Liability
    @PostMapping("addLiability")
    ResponseEntity<Liability> addLiability(@Valid @RequestBody Liability liability) {
        Liability savedLiability = service.addLiability(liability);
        return ResponseEntity.ok(savedLiability);
    }
    @PostMapping("addLiabilities")
    List<Liability> addLiabilities (@Valid @RequestBody List<Liability> liabilities){
        return service.addLiabilities(liabilities);
    }
    @PutMapping("updateLiability")
    Liability updateLiability (@Valid @RequestBody Liability liability){
        return service.updateLiability(liability);
    }
    @PutMapping("updateLiabilities")
    List<Liability> updateLiabilities (@RequestBody List<Liability> liabilities){
        return service.updateLiabilities(liabilities);}
    @DeleteMapping("deleteLiability")
    void deleteLiability(@RequestBody Liability liability){
        service.deleteLiability(liability);
    }
    @DeleteMapping("deleteLiabilityById")
    void deleteLiabilityById(@RequestParam long id){
        service.deleteLiabilityById(id);
    }
    @DeleteMapping("deleteAllLiability")
    void deleteAllLiability(){
        service.deleteAllLiability();
    }
    @DeleteMapping("deleteAllLiabilities")
    void deleteAllLiabilities(@RequestBody List<Liability> liabilities){
        service.deleteAllLiabilities(liabilities);
    }
    @GetMapping("findAllLiabilities")
    List<Liability> findAllLiabilities(){
        return service.findAllLiabilities();
    }
    @GetMapping("findLiabilityById")
    Asset findByIdLiability(@RequestParam long id){
        return service.findByIdAsset(id);
    }



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
