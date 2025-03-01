package tn.coconsultbackend.TrainingManagement;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.coconsultbackend.user.User;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Training training;

    @ManyToMany (mappedBy = "trainingSessions")
    private List<User> trainees;

    @OneToOne
    private User trainer;
}
