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
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRevenue;

    @NotBlank(message = "Revenue source is required")
    private String source;

    @Pattern(regexp = "^(\\d{4})-(0[1-9]|1[0-2])$", message = "period has to be like YYYY-MM")
    private String period;

    @DecimalMin(value = "0.01", message = "Revenue amount cannot be negative")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TypeRevenue type;

    private LocalDate date;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "incomeStatement_id")
            @JsonIgnore
    IncomeStatement incomeStatement;


}
