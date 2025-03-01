package tn.coconsultbackend.TrainingManagement;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private TrainingDifficulty trainingDifficulty;

    @ManyToOne
    private Training training;

    @OneToMany(mappedBy = "trainingLevel")
    private List<TrainingContent> trainingContents;


    private LevelStatus levelStatus;

    @OneToMany(mappedBy = "trainingLevel")
    private List<Quiz> quizzes;
}

