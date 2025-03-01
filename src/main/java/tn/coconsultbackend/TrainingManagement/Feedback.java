package tn.coconsultbackend.TrainingManagement;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.coconsultbackend.user.User;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String message;
    // to add later on
//    @ManyToOne
//    private User tainee;
//    @ManyToOne
//    private  User trainer;
//    @ManyToOne
//    private Training training;

}
