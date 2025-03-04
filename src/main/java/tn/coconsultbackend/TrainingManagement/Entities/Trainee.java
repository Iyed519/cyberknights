package tn.coconsultbackend.TrainingManagement.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Trainee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<TrainingSession> trainingSessions;

    @OneToMany(mappedBy = "trainee")
    private List<Certification> certifications;



}
