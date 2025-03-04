package tn.coconsultbackend.FinanceAndAccountingProcess.Services;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import tn.coconsultbackend.Model.*;

import java.util.List;
public interface IFinanceAndAccountingProcessService {

    //asset
    Asset addAsset(Asset asset);
    Asset updateAsset (long id,Asset asset);
    void deleteAssetById(long id);
    void deleteAllAssets();
    List<Asset> findAllAssets();
    Asset findByIdAsset (long id);
    long countAssets();
    boolean existByIdAsset(long id);


    //Liability
    Liability addLiability(Liability liability);
    Liability updateLiability (long id,Liability liability);
    void deleteLiabilityById(long id);
    void deleteAllLiabilities();
    List<Liability> findAllLiabilities();
    Liability findByIdLiability (long id);
    long countLiability();
    boolean existByIdLiability(long id);

    //revenue
    Revenue addRevenue(Revenue revenue);
    Revenue updateRevenue (long id,Revenue revenue);
    void deleteRevenueById(long id);
    void deleteAllRevenues();
    List<Revenue> findAllRevenues();
    Revenue findByIdRevenue (long id);
    long countRevenues();
    boolean existByIdRevenue(long id);


    //Expense
    Expense addExpense(Expense expense);
    Expense updateExpense (long id,Expense expense);
    void deleteExpenseById(long id);
    void deleteAllExpenses();
    List<Expense> findAllExpenses();
    Expense findByIdExpense (long id);
    long countExpenses();
    boolean existByIdExpense(long id);


    //cashflows
    CashFlows addCashFlows(CashFlows cashFlows);
    CashFlows updateCashFlows (long id,CashFlows cashFlows);
    void deleteCashFlowsById(long id);
    void deleteAllCashFlows();
    List<CashFlows> findAllCashFlows();
    CashFlows findByIdCashFlows (long id);
    long countCashFlows();
    boolean existByIdCashFlows(long id);


    //balance sheet
    BalanceSheet addBalanceSheet(BalanceSheet balanceSheet);
    BalanceSheet updateBalanceSheet (long id,BalanceSheet balanceSheet);
    void deleteBalanceSheetById(long id);
    void deleteAllBalanceSheets();
    List<BalanceSheet> findAllBalanceSheets();
    BalanceSheet findByIdBalanceSheet (long id);
    long countBalanceSheet();
    boolean existByIdBalanceSheet(long id);


    //incomestatement
    IncomeStatement addIncomeStatement(IncomeStatement incomeStatement);
    void deleteAllIncomeStatements ();
    IncomeStatement updateIncomeStatement(long id,IncomeStatement incomeStatement);
    void deleteIncomeStatementById(long id);
    List<IncomeStatement> findAllIncomeStatements();
    IncomeStatement findByIdIncomeStatement(long id);



    //cashflowstatement
    CashFlowStatement addCashFlowStatement(CashFlowStatement cashFlowStatement);
    CashFlowStatement updateCashFlowStatement (long id,CashFlowStatement cashFlowStatement);
    void deleteCashFlowStatementById(long id);
    void deleteAllCashFlowStatement();
    List<CashFlowStatement> findAllCashFlowStatement();
    CashFlowStatement findByIdCashFlowStatement (long id);



}
