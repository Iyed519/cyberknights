package tn.coconsultbackend.FinanceAndAccountingProcess.RestController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.FinanceAndAccountingProcess.Services.IFinanceAndAccountingProcessService;
import tn.coconsultbackend.Model.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RestControllerAdvice
@Validated
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

    @PutMapping("updateLiability")
    ResponseEntity<Liability>  updateLiability (@RequestParam long id,@Valid @RequestBody Liability liability){
        Liability savedLiability = service.updateLiability(id,liability);
        return ResponseEntity.ok(savedLiability);
    }
    @DeleteMapping("deleteLiabilityById/{id}")
    ResponseEntity<Void>  deleteLiabilityById(@RequestParam long id){
        service.deleteLiabilityById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("deleteAllLiabilities")
    ResponseEntity<Void> deleteAllLiabilities(){
        service.deleteAllLiabilities();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("findAllLiabilities")
    ResponseEntity<List<Liability>> findAllLiabilities(){
        return ResponseEntity.ok(service.findAllLiabilities());
    }
    @GetMapping("findLiabilityById/{id}")
    ResponseEntity<Liability>  findByIdLiability(@RequestParam long id){
        return ResponseEntity.ok(service.findByIdLiability(id));
    }



    //Asset

    @PostMapping("addAsset")
    ResponseEntity<Asset> addAsset(@Valid @RequestBody Asset asset) {
        return ResponseEntity.ok(service.addAsset(asset));
    }

    @PutMapping("updateAsset")
    ResponseEntity<Asset> updateAsset (@RequestParam long id,@Valid @RequestBody Asset asset){
        return ResponseEntity.ok(service.updateAsset(id,asset));
    }
    @DeleteMapping("deleteAssetById/{id}")
    ResponseEntity<Void> deleteAssetById(@RequestParam long id){
        service.deleteAssetById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("deleteAllAsset")
    ResponseEntity<Void> deleteAllAssets(){
        service.deleteAllAssets();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("findAllAssets")
    ResponseEntity<List<Asset>> findAllAssets(){
        return ResponseEntity.ok(service.findAllAssets());
    }
    @GetMapping("findAssetById/{id}")
    ResponseEntity<Asset> findByIdAsset (@RequestParam long id){
        return ResponseEntity.ok(service.findByIdAsset(id));
    }


    //revenue

    @PostMapping("addRevenue")
    ResponseEntity<Revenue> addRevenue(@Valid @RequestBody Revenue revenue) {
        return ResponseEntity.ok(service.addRevenue(revenue));
    }
    @PutMapping("updateRevenue")
    ResponseEntity<Revenue> updateRevenue(@RequestParam long id,@Valid @RequestBody Revenue revenue){
        return ResponseEntity.ok(service.updateRevenue(id,revenue));
    }
    @DeleteMapping("deleteRevenueById/{id}")
    ResponseEntity<Void> deleteRevenueById(@RequestParam long id){
        service.deleteRevenueById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("deleteAllRevenue")
    ResponseEntity<Void> deleteAllRevenues(){
        service.deleteAllRevenues();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("findAllRevenues")
    ResponseEntity<List<Revenue>> findAllRevenues(){
        return ResponseEntity.ok(service.findAllRevenues());
    }
    @GetMapping("findRevenueById/{id}")
    ResponseEntity<Revenue> findByIdRevenue (@RequestParam long id){
        return ResponseEntity.ok(service.findByIdRevenue(id));
    }




    //Expense

    @PostMapping("addExpense")
    ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense) {
        return ResponseEntity.ok(service.addExpense(expense));
    }
    @PutMapping("updateExpense")
    ResponseEntity<Expense> updateExpense(@RequestParam long id,@Valid @RequestBody Expense expense){
        return ResponseEntity.ok(service.updateExpense(id,expense));
    }
    @DeleteMapping("deleteExpenseById/{id}")
    ResponseEntity<Void> deleteExpenseById(@RequestParam long id){
        service.deleteExpenseById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("deleteAllExpense")
    ResponseEntity<Void> deleteAllExpenses(){
        service.deleteAllExpenses();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("findAllExpenses")
    ResponseEntity<List<Expense>> findAllExpenses(){
        return ResponseEntity.ok(service.findAllExpenses());
    }
    @GetMapping("findExpenseById/{id}")
    ResponseEntity<Expense> findByIdExpense (@RequestParam long id){
        return ResponseEntity.ok(service.findByIdExpense(id));
    }





    //cashflow

    @PostMapping("addCashFlows")
    ResponseEntity<CashFlows> addCashFlows(@Valid @RequestBody CashFlows cashFlows) {
        return ResponseEntity.ok(service.addCashFlows(cashFlows));
    }
    @PutMapping("updateCashFlows")
    ResponseEntity<CashFlows> updateCashFlows(@RequestParam long id,@Valid @RequestBody CashFlows cashFlows){
        return ResponseEntity.ok(service.updateCashFlows(id,cashFlows));
    }
    @DeleteMapping("deleteCashFlowsById/{id}")
    ResponseEntity<Void> deleteCashFlowsById(@Valid @RequestParam long id){
        service.deleteCashFlowsById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("deleteAllCashFlows")
    ResponseEntity<Void> deleteAllCashFlows(){
        service.deleteAllCashFlows();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("findAllCashFlows")
    ResponseEntity<List<CashFlows>> findAllCashFlows(){
        return ResponseEntity.ok(service.findAllCashFlows());
    }
    @GetMapping("findCashFlowsById/{id}")
    ResponseEntity<CashFlows> findByIdCashFlows (@RequestParam long id){
        return ResponseEntity.ok(service.findByIdCashFlows(id));
    }




    //balancesheet
    @PostMapping("addBalancesheet")
    ResponseEntity<BalanceSheet> addBalanceSheet(@Valid @RequestBody BalanceSheet balanceSheet) {
        return ResponseEntity.ok(service.addBalanceSheet(balanceSheet));

    }
    @PutMapping("updateBalanceSheet")
    ResponseEntity<BalanceSheet> updateBalanceSheet(@RequestParam long id,@Valid @RequestBody BalanceSheet balanceSheet){
        return ResponseEntity.ok(service.updateBalanceSheet(id,balanceSheet));
    }
    @DeleteMapping("deleteBalanceSheetById/{id}")
    ResponseEntity<Void> deleteBalanceSheetById(@RequestParam long id){
        service.deleteBalanceSheetById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("deleteAllBalanceSheet")
    ResponseEntity<Void> deleteAllBalanceSheets(){
        service.deleteAllBalanceSheets();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("findAllBalanceSheets")
    ResponseEntity<List<BalanceSheet>> findAllBalanceSheets(){
        return ResponseEntity.ok(service.findAllBalanceSheets());
    }
    @GetMapping("findBalanceSheetById/{id}")
    ResponseEntity<BalanceSheet> findByIdBalanceSheet (@RequestParam long id){
        return ResponseEntity.ok(service.findByIdBalanceSheet(id));
    }


    //incomestatement
    @PostMapping("addIncomeStatement")
    ResponseEntity<IncomeStatement> addIncomeStatement(@Valid @RequestBody IncomeStatement incomeStatement) {
        return ResponseEntity.ok(service.addIncomeStatement(incomeStatement));}

    @DeleteMapping("deleteAllIncomeStatement")
    ResponseEntity<Void>  deleteAllIncomeStatement(){
        service.deleteAllIncomeStatements();
        return ResponseEntity.noContent().build();
    }
    @PutMapping("updateIncomeStatement")
    ResponseEntity<IncomeStatement> updateIncomeStatement(@RequestParam long id,@Valid @RequestBody IncomeStatement incomeStatement){
        return ResponseEntity.ok(service.updateIncomeStatement(id,incomeStatement));
    }
    @DeleteMapping("deleteIncomeStatementById/{id}")
    ResponseEntity<Void> deleteIncomeStatementById(@RequestParam long id){
        service.deleteIncomeStatementById(id);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("findAllIncomeStatements")
    ResponseEntity<List<IncomeStatement>> findAllIncomeStatements(){
        return ResponseEntity.ok(service.findAllIncomeStatements());
    }
    @GetMapping("findIncomeStatementById/{id}")
    ResponseEntity<IncomeStatement> findByIdIncomeStatement (@RequestParam long id) {
        return ResponseEntity.ok(service.findByIdIncomeStatement(id));
    }

}
