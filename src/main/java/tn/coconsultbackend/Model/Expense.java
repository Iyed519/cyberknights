package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExpense;

    @NotBlank(message = "description type is required")
    private String description;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "period must be in the format YYYY-MM-DD")
    private String period;

    @DecimalMin(value = "0.0", message = "Expense amount cannot be negative")
    private float amount;

    @Enumerated(EnumType.STRING)
    private TypeExpense type;

    private LocalDate date;



    @ManyToOne
    @JoinColumn(name = "incomeStatement_id")
    IncomeStatement incomeStatement;
}



