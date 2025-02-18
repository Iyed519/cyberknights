package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BalanceSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBalanceSheet;
    private int num;
    private String name;
    private String description;
    private LocalDate date;
    private float amount;



    @OneToMany(mappedBy = "balanceSheet",fetch = FetchType.EAGER)
    List<Asset> assets;

    @OneToMany(mappedBy = "balanceSheet",fetch = FetchType.EAGER)
    List<Liability> liabilities;

    @OneToOne(mappedBy = "balanceSheet")
    FinancialReport financialReport;

}
