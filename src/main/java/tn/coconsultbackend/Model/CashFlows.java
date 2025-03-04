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
public class CashFlows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCashFlows;

    @NotBlank(message = "Description is required")
    private String description;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "period must be in the format YYYY-MM-DD")
    private String period;

    @DecimalMin(value = "0.0", message = "Transaction amount cannot be negative")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TypeFlows type;

    @Enumerated(EnumType.STRING)
    private CategorieFlows categorie;
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cashFlowStatement_id")
    @JsonIgnore
    private CashFlowStatement cashFlowStatement;

}
