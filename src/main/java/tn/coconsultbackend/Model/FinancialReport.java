package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinancialReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFinancialReport;
    private int num;
    private LocalDate date;
    private String description;

    @OneToOne
    BalanceSheet balanceSheet;
    @OneToOne
    IncomeStatement incomeStatement;
    @OneToOne
    CashFlows cashFlows;
}
