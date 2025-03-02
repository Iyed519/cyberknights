package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "period"))
public class CashFlowStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCashFlowStatement ;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^(\\d{4})-(0[1-9]|1[0-2])$", message = "The period must be in the format YYYY-MM")
    private String period;

    @DecimalMin(value = "0.0", message = "Cash inflows cannot be negative")
    private BigDecimal totalInflows ;

    @DecimalMin(value = "0.0", message = "Cash outflows cannot be negative")
    private BigDecimal totalOutflows ;

    private BigDecimal netCashFlow ;

    private LocalDate date;

    @OneToMany(mappedBy = "cashFlowStatement",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CashFlows> transactions;
    @OneToOne(mappedBy = "cashFlowStatement")
    FinancialReport financialReport;
}

