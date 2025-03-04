package tn.coconsultbackend.TrainingManagement.Services;

import tn.coconsultbackend.TrainingManagement.Entities.Training;

import java.util.List;

public interface ITrainingService {

    Training getTraining(int id);
    List<Training> getAllTrainings();

    Training addTraining(Training training);

    Training updateTraining(long id, Training training);

    void deleteTraining(int id);



}
