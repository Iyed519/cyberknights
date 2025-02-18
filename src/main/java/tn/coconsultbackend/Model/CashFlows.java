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
public class CashFlows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCashFlows;
    private String name;
    private String description;
    private float amount;
    @Enumerated(EnumType.STRING)
    private TypeFlows type;
    @Enumerated(EnumType.STRING)
    private CategorieFlows categorie;
    private LocalDate date;

    @OneToOne(mappedBy = "cashFlows")
    FinancialReport financialReport;

}
