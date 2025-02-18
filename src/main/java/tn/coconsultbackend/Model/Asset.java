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
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsset;
    private String description;
    private float purchaseValue;
    private float currentValue;
    @Enumerated(EnumType.STRING)
    private TypeAsset type;
    private LocalDate acquisitionDate;


    @ManyToOne
    BalanceSheet balanceSheet;
}
