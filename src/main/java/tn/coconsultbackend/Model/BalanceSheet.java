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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "periode"))
public class BalanceSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBalanceSheet;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^(\\d{4})-(0[1-9]|1[0-2])$", message = "period has to be like YYYY-MM")
    private String period;

    @DecimalMin(value = "0.0", inclusive = true, message = "total of the assets can't be negative")
    private BigDecimal totalAssets;

    @DecimalMin(value = "0.0", inclusive = true, message = "Total of the liabilities can't be negative")
    private BigDecimal totalLiabilities;

    private BigDecimal resultatNet;

    private LocalDate date;




    @OneToMany(mappedBy = "balanceSheet",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Asset> assets;

    @OneToMany(mappedBy = "balanceSheet",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Liability> liabilities;

    @OneToOne(mappedBy = "balanceSheet")
    FinancialReport financialReport;

}
