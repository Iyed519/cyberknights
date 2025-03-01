package tn.coconsultbackend.TrainingManagement;

import jakarta.persistence.OneToOne;
import tn.coconsultbackend.user.User;

public class Trainer extends User {

    @OneToOne(mappedBy = "trainer")
    private TrainingSession trainingSession;

}
