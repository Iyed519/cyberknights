package tn.coconsultbackend.FinanceAndAccountingProcess.Services;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.FinanceAndAccountingProcess.Repositories.*;
import tn.coconsultbackend.Model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class FinanceAndAccountingProcessService implements IFinanceAndAccountingProcessService {
    @Autowired
    AssetRepository ar;
    @Autowired
    LiabilityRepository lr;
    @Autowired
    BalanceSheetRepository bsr;
    @Autowired
    IncomeStatementRepository isr;
    @Autowired
    ExpenseRepository er;
    @Autowired
    RevenueRepository rr;
    @Autowired
    CashFlowsRepository cfr;
    @Autowired
    CashFlowStatementRepository cfsr;

    //asset
    @Override
    public Asset addAsset(Asset asset) {
        BalanceSheet bs=bsr.findByPeriod(asset.getPeriod());
        asset.setAcquisitionDate(asset.getAcquisitionDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        asset.setPeriod(asset.getAcquisitionDate().format(formatter));
        if(bs!=null){
            asset.setBalanceSheet(bs);
            BigDecimal newTotal = bs.getTotalAssets().add(asset.getValue());
            bs.setTotalAssets(newTotal);
            bsr.save(bs);
        }

        return ar.save(asset);
    }

    @Override
    public Asset updateAsset(long id, Asset asset) {
        Asset a = ar.findByIdAsset(id);
        a.setAcquisitionDate(asset.getAcquisitionDate());
        a.setDescription(asset.getDescription());
        a.setValue(asset.getValue());
        a.setCategorieAsset(asset.getCategorieAsset());
        a.setTypeAsset(asset.getTypeAsset());
        a.setAcquisitionDate(asset.getAcquisitionDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        a.setPeriod(a.getAcquisitionDate().format(formatter));
        BalanceSheet bs=bsr.findByPeriod(a.getPeriod());
        a.setBalanceSheet(bs);
        BigDecimal newTotal = bs.getTotalAssets().add(asset.getValue());
        bs.setTotalAssets(newTotal);
        bsr.save(bs);
        return ar.save(a);
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
    public Liability addLiability( Liability liability) {
        BalanceSheet bs=bsr.findByPeriod(liability.getPeriod());
        liability.setDueDate(liability.getDueDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        liability.setPeriod(liability.getDueDate().format(formatter));
        if(bs!=null){
            liability.setBalanceSheet(bs);
            BigDecimal newTotal = bs.getTotalLiabilities().add(liability.getAmount());
            bs.setTotalLiabilities(newTotal);
            bsr.save(bs);
        }




        return lr.save(liability);
    }


    @Override
    public Liability updateLiability(long id, Liability liability) {
        Liability li = lr.findByIdLiability(id);
        li.setName(liability.getName());
        li.setAmount(liability.getAmount());
        li.setCategorieLiability(liability.getCategorieLiability());
        li.setTypeLiability(liability.getTypeLiability());
        li.setDueDate(liability.getDueDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        li.setPeriod(liability.getDueDate().format(formatter));
        BalanceSheet bs=bsr.findByPeriod(li.getPeriod());
         li.setBalanceSheet(bs);
         BigDecimal newTotal = bs.getTotalLiabilities().add(liability.getAmount());
         bs.setTotalLiabilities(newTotal);
     bsr.save(bs);



       return lr.save(li);

    }

    @Override
    public void deleteLiabilityById(long id) {
        lr.deleteById(id);

    }


    @Override
    public void deleteAllLiabilities() {
        lr.deleteAll();

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





    //revenue

    @Override
    public Revenue addRevenue(Revenue revenue) {
        IncomeStatement is=isr.findByPeriod(revenue.getPeriod());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        revenue.setPeriod(revenue.getDate().format(formatter));
        if(is!=null){
            revenue.setIncomeStatement(is);
            BigDecimal newTotal = is.getTotalRevenues().add(revenue.getAmount());
            is.setTotalRevenues(newTotal);
            isr.save(is);

        }

        return rr.save(revenue);
    }


    @Override
    public Revenue updateRevenue(long id, Revenue revenue) {
        Revenue r= rr.findByIdRevenue(id);
        r.setAmount(revenue.getAmount());
        r.setSource(revenue.getSource());
        r.setType(revenue.getType());
        r.setDate(revenue.getDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        r.setPeriod(revenue.getDate().format(formatter));
        IncomeStatement is=isr.findByPeriod(r.getPeriod());
        r.setIncomeStatement(is);
        BigDecimal newTotal = is.getTotalRevenues().add(revenue.getAmount());
        is.setTotalRevenues(newTotal);
        isr.save(is);
        return rr.save(r);
    }
    @Override
    public void deleteRevenueById(long id) {
        if (!rr.existsById(id)) {
            throw new RuntimeException("Revenue not found");
        }
        rr.deleteById(id);


    }

    @Override
    public void deleteAllRevenues() {
        rr.deleteAll();

    }

    @Override
    public List<Revenue> findAllRevenues() {
        return rr.findAll();
    }

    @Override
    public Revenue findByIdRevenue(long id) {
        return rr.findById(id).get();
    }

    @Override
    public long countRevenues() {
        return rr.count();
    }

    @Override
    public boolean existByIdRevenue(long id) {
        return rr.existsById(id);
    }



    //Expense
    @Override
    public Expense addExpense(Expense expense) {
        IncomeStatement is=isr.findByPeriod(expense.getPeriod());
        expense.setDate(expense.getDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        expense.setPeriod(expense.getDate().format(formatter));
        if(is!=null){
            expense.setIncomeStatement(is);
            BigDecimal newTotal = is.getTotalExpenses().add(expense.getAmount());
            is.setTotalExpenses(newTotal);
            isr.save(is);

        }

        return er.save(expense);
    }

    @Override
    public Expense updateExpense(long id, Expense expense) {
        Expense e= er.findByIdExpense(id);
        e.setAmount(expense.getAmount());
        e.setDescription(expense.getDescription());
        e.setType(expense.getType());
        e.setDate(expense.getDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        e.setPeriod(expense.getDate().format(formatter));

        IncomeStatement is=isr.findByPeriod(e.getPeriod());

        e.setIncomeStatement(is);
        BigDecimal newTotal = is.getTotalExpenses().add(expense.getAmount());
        is.setTotalExpenses(newTotal);
        isr.save(is);

        return er.save(e);
    }

    @Override
    public void deleteExpenseById(long id) {
        er.deleteById(id);

    }

    @Override
    public void deleteAllExpenses() {
        er.deleteAll();

    }

    @Override
    public List<Expense> findAllExpenses() {
        return er.findAll();
    }

    @Override
    public Expense findByIdExpense(long id) {
        return er.findById(id).get();
    }

    @Override
    public long countExpenses() {
        return er.count();
    }

    @Override
    public boolean existByIdExpense(long id) {
        return er.existsById(id);
    }



    //cashflow

    @Override
    public CashFlows addCashFlows(CashFlows cashFlows) {
        CashFlowStatement cfs=cfsr.findByPeriod(cashFlows.getPeriod());
        cashFlows.setDate(cashFlows.getDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        cashFlows.setPeriod(cashFlows.getDate().format(formatter));
        cashFlows.setCashFlowStatement(cfs);
        if(cashFlows.getType().equals(TypeFlows.INFLOWS)){
        BigDecimal newTotal = cfs.getTotalInflows().add(cashFlows.getAmount());
        cfs.setTotalInflows(newTotal);}
        if(cashFlows.getType().equals(TypeFlows.OUTFLOWS)){
            BigDecimal newTotal = cfs.getTotalOutflows().add(cashFlows.getAmount());
            cfs.setTotalOutflows(newTotal);
        }
        cfsr.save(cfs);
        return cfr.save(cashFlows);
    }

    @Override
    public CashFlows updateCashFlows(long id, CashFlows cashFlows) {
        CashFlows cf=cfr.findByIdCashFlows(id);
        cf.setAmount(cashFlows.getAmount());
        cf.setDescription(cashFlows.getDescription());
        cf.setType(cashFlows.getType());
        cf.setCategorie(cashFlows.getCategorie());
        cf.setDate(cashFlows.getDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        cf.setPeriod(cashFlows.getDate().format(formatter));
        CashFlowStatement cfs=cfsr.findByPeriod(cf.getPeriod());

        cf.setCashFlowStatement(cfs);
        if(cf.getType().equals(TypeFlows.INFLOWS)){
            BigDecimal newTotal = cfs.getTotalInflows().add(cf.getAmount());
            cfs.setTotalInflows(newTotal);}
        if(cf.getType().equals(TypeFlows.OUTFLOWS)){
            BigDecimal newTotal = cfs.getTotalOutflows().add(cf.getAmount());
            cfs.setTotalOutflows(newTotal);
        }
        cfsr.save(cfs);
        return cfr.save(cf);
    }

    @Override
    public void deleteCashFlowsById(long id) {
        cfr.deleteById(id);

    }

    @Override
    public void deleteAllCashFlows() {
        cfr.deleteAll();

    }

    @Override
    public List<CashFlows> findAllCashFlows() {
        return cfr.findAll();
    }

    @Override
    public CashFlows findByIdCashFlows(long id) {
        return cfr.findById(id).get();
    }

    @Override
    public long countCashFlows() {
        return cfr.count();
    }

    @Override
    public boolean existByIdCashFlows(long id) {
        return cfr.existsById(id);

    }


    //BALANCEsheet

    @Override
    public BalanceSheet addBalanceSheet(BalanceSheet balanceSheet) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        balanceSheet.setPeriod(balanceSheet.getDate().format(formatter));
        BigDecimal totalCostAsset = BigDecimal.ZERO;
        BigDecimal totalCostLiability = BigDecimal.ZERO;
        List<Asset> assets = ar.findAllByPeriod(balanceSheet.getPeriod());
        List<Liability> liabilities = lr.findAllByPeriod(balanceSheet.getPeriod());
        balanceSheet.setDate(LocalDate.now());
        if(assets.size()>0) {

            for (Asset asset : assets) {
                totalCostAsset = totalCostAsset.add(asset.getValue()); }
            balanceSheet.setTotalAssets(totalCostAsset);

        }
        if(liabilities.size()>0) {
            for (Liability liability : liabilities) {
                totalCostLiability = totalCostLiability.add(liability.getAmount());
            }
            balanceSheet.setTotalLiabilities(totalCostLiability);

        }
        balanceSheet.setResultatNet(totalCostAsset.subtract(totalCostLiability));

        return bsr.save(balanceSheet);
    }

    @Override
    public BalanceSheet updateBalanceSheet(long id, BalanceSheet balanceSheet) {
        return bsr.save(balanceSheet);
    }

    @Override
    public void deleteBalanceSheetById(long id) {
        bsr.deleteById(id);

    }

    @Override
    public void deleteAllBalanceSheets() {
        bsr.deleteAll();

    }

    @Override
    public List<BalanceSheet> findAllBalanceSheets() {
        return bsr.findAll();
    }

    @Override
    public BalanceSheet findByIdBalanceSheet(long id) {
        return bsr.findById(id).get();
    }

    @Override
    public long countBalanceSheet() {
        return bsr.count();
    }

    @Override
    public boolean existByIdBalanceSheet(long id) {
        return bsr.existsById(id);
    }


    //income

    @Override
    public IncomeStatement addIncomeStatement(IncomeStatement incomeStatement) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        incomeStatement.setPeriod(incomeStatement.getDate().format(formatter));
        BigDecimal totalRevenue = BigDecimal.ZERO;
        BigDecimal totale = BigDecimal.ZERO;
        List<Revenue> r = rr.findByPeriod(incomeStatement.getPeriod());
        List<Expense> e = er.findByPeriod(incomeStatement.getPeriod());
        incomeStatement.setDate(LocalDate.now());
        if(r.size()>0) {

            for (Revenue revenue : r) {
                totalRevenue = totalRevenue.add(revenue.getAmount()); }
            incomeStatement.setTotalRevenues(totalRevenue);

        }
        if(e.size()>0) {
            for (Expense expense : e) {
                totale = totale.add(expense.getAmount());
            }
            incomeStatement.setTotalExpenses(totale);

        }
        incomeStatement.setNetIncome(totalRevenue.subtract(totale));

        return isr.save(incomeStatement);
    }

    @Override
    public void deleteAllIncomeStatements() {
        isr.deleteAll();
    }

    @Override
    public IncomeStatement updateIncomeStatement(long id, IncomeStatement incomeStatement) {
        return isr.save(incomeStatement);
    }

    @Override
    public void deleteIncomeStatementById(long id) {
        isr.deleteById(id);

    }

    @Override
    public List<IncomeStatement> findAllIncomeStatements() {
        return isr.findAll();
    }

    @Override
    public IncomeStatement findByIdIncomeStatement(long id) {
        return isr.findById(id).get();
    }





    //cashflowstatement
    @Override
    public CashFlowStatement addCashFlowStatement(CashFlowStatement cashFlowStatement) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        CashFlowStatement.set
        BigDecimal totalinflow = BigDecimal.ZERO;
        BigDecimal totaloutflow = BigDecimal.ZERO;
        if()
        List<CashFlows> in= cfr.findByPeriod(incomeStatement.getPeriod());
        List<CashFlows> out = cfr.findByPeriod(incomeStatement.getPeriod());
        incomeStatement.setDate(LocalDate.now());
        if(r.size()>0) {

            for (Revenue revenue : r) {
                totalRevenue = totalRevenue.add(revenue.getAmount()); }
            incomeStatement.setTotalRevenues(totalRevenue);

        }
        if(e.size()>0) {
            for (Expense expense : e) {
                totale = totale.add(expense.getAmount());
            }
            incomeStatement.setTotalExpenses(totale);

        }
        incomeStatement.setNetIncome(totalRevenue.subtract(totale));

        return isr.save(incomeStatement);
    }


    @Override
    public CashFlowStatement updateCashFlowStatement(long id, CashFlowStatement cashFlowStatement) {
        return null;
    }

    @Override
    public void deleteCashFlowStatementById(long id) {

    }

    @Override
    public void deleteAllCashFlowStatement() {

    }

    @Override
    public List<CashFlowStatement> findAllCashFlowStatement() {
        return List.of();
    }

    @Override
    public CashFlowStatement findByIdCashFlowStatement(long id) {
        return null;
    }


}
