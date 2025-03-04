package tn.coconsultbackend.TrainingManagement.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float passingScore;
    private Float maxScore;
    private Float evaluationScore;
    private Boolean isEvaluationValidated;


    @OneToOne(fetch = FetchType.EAGER)
    private TrainingLevel trainingLevel;

    @OneToOne (fetch = FetchType.LAZY)
    private Certification certification;




}
