package tn.coconsultbackend.Model;

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
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRevenue;

    @NotBlank(message = "Revenue source is required")
    private String source;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "period must be in the format YYYY-MM-DD")
    private String period;

    @DecimalMin(value = "0.0", message = "Revenue amount cannot be negative")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TypeRevenue type;

    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "incomeStatement_id")
    IncomeStatement incomeStatement;


}
