package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NonConformance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long nc_id;
    private String description;
    private String analysis_manager;
    private String treatement_manager;
    @Enumerated(EnumType.STRING)
    private DefaultType defaultType;
    private String Causes;
    @Enumerated(EnumType.STRING)
    private NCSource source;
}
