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
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExpense;

    private String description;
    private float amount;
    @Enumerated(EnumType.STRING)
    private TypeExpense type; // e.g., "Chiffre d'Affaires", "Revenus Financiers"
    private LocalDate date;



    @ManyToOne
    IncomeStatement incomeStatement;
}



