package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorrectionEfficiency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long effId;
    @Enumerated(EnumType.STRING)
    private Efficiency efficiency;
    private String efficiency_proof;
}
