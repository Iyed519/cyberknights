package tn.coconsultbackend.TrainingManagement.Entities;


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
    private Long id;

    private String name;
    private String description;
    private TrainingDifficulty trainingDifficulty;

    @ManyToOne
    private Training training;

    @OneToMany(mappedBy = "trainingLevel")
    private List<TrainingContent> trainingContents;


    private LevelStatus levelStatus;

    @OneToMany
    private List<Quiz> quizzes;

    @OneToMany(mappedBy = "trainingLevel")
    private List<TrainingSession> trainingSessions;
}

