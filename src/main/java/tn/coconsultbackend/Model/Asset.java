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
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsset;

    @NotBlank(message = "Le nom de l'actif est obligatoire")
    private String description;

    @Pattern(regexp = "^(\\d{4})-(0[1-9]|1[0-2])$", message = "period has to be like YYYY-MM")
    private String period;

    @DecimalMin(value = "0.01", message = "value can't be negative")
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private TypeAsset typeAsset;

    @Enumerated(EnumType.STRING)
    private CategorieAsset categorieAsset;

    private LocalDate acquisitionDate;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "balanceSheet_id")
    @JsonIgnore
    BalanceSheet balanceSheet;
}
