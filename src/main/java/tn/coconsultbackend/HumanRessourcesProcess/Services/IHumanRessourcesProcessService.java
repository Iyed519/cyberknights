package tn.coconsultbackend.HumanRessourcesProcess.Services;

import tn.coconsultbackend.Model.*;

import java.util.List;

public interface IHumanRessourcesProcessService {
    // Training methods
    Training addTraining(Training training);
    Training updateTraining(Long id, Training training);
    void deleteTraining(Long id);
    Training getTrainingById(Long id);
    List<Training> getAllTrainings();

    // EmploymentEvaluation methods
    EmploymentEvaluation addEmploymentEvaluation(EmploymentEvaluation evaluation);
    EmploymentEvaluation updateEmploymentEvaluation(Long id, EmploymentEvaluation evaluation);
    void deleteEmploymentEvaluation(Long id);
    EmploymentEvaluation getEmploymentEvaluationById(Long id);
    List<EmploymentEvaluation> getAllEmploymentEvaluations();

    // Post methods
    Post addPost(Post post);
    Post getPostById(Long id);
    List<Post> getAllPosts();
    Post updatePost(Long id, Post updatedPost);
    void deletePost(Long id);

    // EducationalRessources methods
    EducationalRessources addResource(EducationalRessources resource);
    List<EducationalRessources> getAllResources();
    EducationalRessources getResourceById(Long id);
    EducationalRessources updateResource(Long id, EducationalRessources updatedResource);
    void deleteResource(Long id);

    //Certification
    Certification addCertification(Certification certification);
    Certification getCertificationById(Long id);
    Certification updateCertification(Long id, Certification certification);
    void deleteCertification(Long id);
    List<Certification> getAllCertifications();

    //operationTask
    OperationTask addOperationTask(OperationTask operationTask);
    List<OperationTask> getAllOperationTasks();
    OperationTask updateOperationTask(Long id, OperationTask operationTask);
    void deleteOperationTask(Long id);
    OperationTask getOperationTaskById(Long id);

    //candidate evaluation
    CandidateEvaluation addCandidateEvaluation(CandidateEvaluation candidateEvaluation);
    List<CandidateEvaluation> getAllCandidateEvaluations();
    CandidateEvaluation updateCandidateEvaluation(Long id, CandidateEvaluation candidateEvaluation);
    void deleteCandidateEvaluation(Long id);
    CandidateEvaluation getCandidateEvaluationById(Long id);

}
