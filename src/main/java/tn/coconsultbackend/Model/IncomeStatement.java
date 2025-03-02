package tn.coconsultbackend.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;
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

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^(\\d{4})-(0[1-9]|1[0-2])$", message = "The period must be in the format YYYY-MM")
    private String period;

    @DecimalMin(value = "0.0", message = "Total revenues cannot be negative")
    private BigDecimal totalRevenues ;

    @DecimalMin(value = "0.0", message = "Total expenses cannot be negative")
    private BigDecimal totalExpenses ;

    private LocalDate date;
    private BigDecimal netIncome;



    @OneToMany(mappedBy = "incomeStatement",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Revenue> revenues;

    @OneToMany(mappedBy = "incomeStatement",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Expense> expenses;

    @OneToOne(mappedBy = "incomeStatement")
    FinancialReport financialReport;




}
