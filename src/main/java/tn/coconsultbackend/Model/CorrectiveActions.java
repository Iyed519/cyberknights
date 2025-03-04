package tn.coconsultbackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorrectiveActions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long caId;
    private String description;
    private String planning_manager;
    private LocalDate planning_date;
    private String realization_manager;
    private LocalDate realization_date;
    private String verifictation_manager;
    private LocalDate verifictation_date;
    private String treatement_manager;
    private LocalDate treatement_date;
}
