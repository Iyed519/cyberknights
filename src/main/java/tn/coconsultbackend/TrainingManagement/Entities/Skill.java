package tn.coconsultbackend.TrainingManagement.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private SkillLevel skillLevel;
    private SkillType skillType;

    @ManyToOne
    private Training training;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
