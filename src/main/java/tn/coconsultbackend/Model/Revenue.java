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
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRevenue;

    private String source;
    private float amount;
    @Enumerated(EnumType.STRING)
    private TypeRevenue type; // e.g., "Chiffre d'Affaires", "Revenus Financiers"
    private LocalDate date;


    @ManyToOne
    IncomeStatement incomeStatement;


}
