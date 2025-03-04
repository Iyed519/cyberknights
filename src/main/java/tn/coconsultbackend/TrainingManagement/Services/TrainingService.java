package tn.coconsultbackend.TrainingManagement.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.TrainingManagement.Entities.Training;
import tn.coconsultbackend.TrainingManagement.Repositories.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService implements ITrainingService {

    private final TrainingRepository trainingRepository;
    private final SkillRepository skillRepository;
    private final TrainingLevelRepository trainingLevelRepository;
    private final TrainingContentRepository trainingContentRepository;
    private final FeedbackRepository feedbackRepository;

    @Override
    public Training getTraining(int id) {
        if (trainingRepository == null) {
            throw new IllegalStateException("TrainingRepository is null!");
        }
        return trainingRepository.findTrainingById(id); }

    @Override
    public Training addTraining(Training training) {
        if (training.getFeedbacks() != null) {
            feedbackRepository.saveAll(training.getFeedbacks());}
        if (training.getTrainingLevels() != null) {
            trainingLevelRepository.saveAll(training.getTrainingLevels());}
        if (training.getSkills() != null) {
            skillRepository.saveAll(training.getSkills());}

        return trainingRepository.save(training);
    }

    @Override
    public Training updateTraining(long id, Training training){

            if (training == null) {
                throw new IllegalStateException("Training is null!");
            }
            else {
            Training newTraining = trainingRepository.findTrainingById(id);
            newTraining.setName(training.getName());
            newTraining.setDescription(training.getDescription());
            newTraining.setLocation(training.getLocation());
            newTraining.setTrainingStatus(training.getTrainingStatus());

            if (training.getFeedbacks() != null) {
                feedbackRepository.saveAll(training.getFeedbacks());
                newTraining.setFeedbacks(training.getFeedbacks());}
            if (training.getTrainingLevels() != null) {
                trainingLevelRepository.saveAll(training.getTrainingLevels());
                newTraining.setTrainingLevels(training.getTrainingLevels());}
            if (training.getSkills() != null) {
                skillRepository.saveAll(training.getSkills());
                newTraining.setSkills(training.getSkills());}

            return trainingRepository.save(newTraining);
        }
    }

    @Override
    public void deleteTraining(int id) {

    }

    @Override
    public List<Training> getAllTrainings() {
        return List.of();
    }
}
