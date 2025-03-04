package tn.coconsultbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "period"))
public class FinancialReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFinancialReport;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^(\\d{4})-(0[1-9]|1[0-2])$", message = "The period must be in the format YYYY-MM")
    private String period;

    @DecimalMin(value = "0.0", message = "Total assets cannot be negative")
    private BigDecimal totalAssets ;

    @DecimalMin(value = "0.0", message = "Total liabilities cannot be negative")
    private BigDecimal totalLiabilities ;

    @DecimalMin(value = "0.0", message = "Total revenues cannot be negative")
    private BigDecimal totalRevenues ;

    @DecimalMin(value = "0.0", message = "Total expenses cannot be negative")
    private BigDecimal totalExpenses ;

    private BigDecimal netProfit ;
    private BigDecimal netCashFlow ;

    @NotBlank(message = "Performance evaluation is required")
    private String performanceEvaluation;

    @OneToOne
    @JoinColumn(name = "balanceSheet_id")
    @JsonIgnore
    private BalanceSheet balanceSheet;

    @OneToOne
    @JoinColumn(name = "incomeStatement_id")
    @JsonIgnore
    private IncomeStatement incomeStatement;

    @OneToOne
    @JoinColumn(name = "cashFlowStatement_id")
    @JsonIgnore
    private CashFlowStatement cashFlowStatement;
}
