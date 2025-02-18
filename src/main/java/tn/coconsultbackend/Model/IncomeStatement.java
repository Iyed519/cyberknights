package tn.coconsultbackend.Model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncomeStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIcomeStatement;
    private String period;
    private LocalDate date;
    private String description;
    private float netIncome;



    @OneToMany(mappedBy = "incomeStatement",fetch = FetchType.EAGER)
    List<Revenue> revenues;

    @OneToMany(mappedBy = "incomeStatement",fetch = FetchType.EAGER)
    List<Expense> expenses;

    @OneToOne(mappedBy = "incomeStatement")
    FinancialReport financialReport;




}
