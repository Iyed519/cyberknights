package tn.coconsultbackend.TrainingManagement.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String description;
    private LocalDate issueDate;


    @OneToOne(mappedBy = "certification",fetch = FetchType.LAZY)
    private Evaluation evaluation;

    @ManyToOne
//            (fetch = FetchType.LAZY)
    private Trainee trainee;




}

