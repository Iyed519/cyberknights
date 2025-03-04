package tn.coconsultbackend.TrainingManagement.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

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
    private Long id;

    @NotBlank(message = "name must not be blank")
    @NotEmpty(message = "name must not be empty")
    private String name;

    @NotBlank(message = "name must not be blank")
    @NotEmpty(message = "name must not be empty")
    private String description;

    @NotBlank(message = "name must not be blank")
    @NotEmpty(message = "name must not be empty")
    private String location;

//    @JsonIgnore
    private TrainingStatus trainingStatus;

//    @JsonIgnore
    @OneToMany(mappedBy = "training")
    private List<Skill> skills;

//    @JsonIgnore
    @OneToMany(mappedBy = "training")
    private List<TrainingLevel> TrainingLevels;

//    @JsonIgnore
    @OneToMany(mappedBy = "training")
    private List<Feedback> feedbacks;









}
