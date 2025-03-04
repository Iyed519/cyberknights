package tn.coconsultbackend.TrainingManagement.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;



    @ManyToMany (mappedBy = "trainingSessions")
    private List<Trainee> trainees;

    @ManyToOne
    private Trainer trainer;

    @ManyToOne
    private TrainingLevel trainingLevel;
}
