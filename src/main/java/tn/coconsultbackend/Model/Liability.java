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
public class Liability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLiability;

    private float amount; // The liability amount (e.g., loan, payable)
    private TypeLiability type; // Type of liability (e.g., "Short Term Debt", "Long Term Debt")
    private LocalDate dueDate; // Due date for repayment
    private String status;



    @ManyToOne
    BalanceSheet balanceSheet;
}
