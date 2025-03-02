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
public class Liability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLiability;

    @NotBlank(message = "Liability name is required")
    private String name;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "period must be in the format YYYY-MM-DD")
    private String period;

    @DecimalMin(value = "0.0", message = "Liability amount cannot be negative")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TypeLiability typeLiability;

    @Enumerated(EnumType.STRING)
    private CategorieLiability categorieLiability;

    private LocalDate dueDate;



    @ManyToOne
    @JoinColumn(name = "balanceSheet_id")
    BalanceSheet balanceSheet;
}
