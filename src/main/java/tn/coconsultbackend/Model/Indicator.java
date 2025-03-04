package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long indicatorId;
    private String indicatorCode;
    private String label;
    private String calculationMethod;
    @Enumerated(EnumType.STRING)
    private Frequency frequency;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private Double targetValue;
    private Boolean isActive;

    @ManyToOne
    private ISOSession session;

}
