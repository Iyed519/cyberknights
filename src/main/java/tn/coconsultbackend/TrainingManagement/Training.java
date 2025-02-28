package tn.coconsultbackend.TrainingManagement;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import tn.coconsultbackend.user.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "name must not be blank")
    @NotEmpty(message = "name must not be empty")
    private String name;

    private String description;
    private String location;

    @OneToMany(mappedBy = "training")
    private List<TrainingSession> trainingSessions;

    @OneToMany(mappedBy = "training")
    private List<Skill> skills;

    @OneToMany(mappedBy = "training")
    private List<TrainingLevel> TrainingLevels;

    private TrainingStatus trainingStatus;

    @OneToMany(mappedBy = "training")
    private List<TrainingContent> trainingContents;



}
