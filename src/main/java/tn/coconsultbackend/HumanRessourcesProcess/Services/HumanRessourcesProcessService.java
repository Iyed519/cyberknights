package tn.coconsultbackend.HumanRessourcesProcess.Services;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.HumanRessourcesProcess.Repositories.*;
import tn.coconsultbackend.Model.*;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class HumanRessourcesProcessService implements IHumanRessourcesProcessService {

    @Autowired
    private final TrainingRepository trainingRepository;
    @Autowired
    private final EmploymentEvaluationRepository employmentEvaluationRepository;
    @Autowired
    private final EducationalRessourcesRepository educationalRessourcesRepository;
    @Autowired
    private final CertificationRepository certificationRepository;
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final OperationTaskRepository operationTaskRepository;
    @Autowired
    private final CandidateEvaluationRepository candidateEvaluationRepository;

    //training methods
    @Override
    public Training addTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Training updateTraining(Long id, Training training) {
        Optional<Training> existingTraining = trainingRepository.findById(id);
        if (existingTraining.isPresent()) {
            Training updatedTraining = existingTraining.get();
            updatedTraining.setName(training.getName());
            updatedTraining.setDescription(training.getDescription());
            updatedTraining.setDuration(training.getDuration());
            updatedTraining.setLocation(training.getLocation());
            return trainingRepository.save(updatedTraining);
        } else {
            return null;
        }

    }

    @Override
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }

    @Override
    public Training getTrainingById(Long id) {
        return trainingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    // EmploymentEvaluation methods
    @Override
    public EmploymentEvaluation addEmploymentEvaluation(EmploymentEvaluation evaluation) {
        return employmentEvaluationRepository.save(evaluation);
    }

    @Override
    public EmploymentEvaluation updateEmploymentEvaluation(Long id, EmploymentEvaluation evaluation) {
        Optional<EmploymentEvaluation> existingEvaluation = employmentEvaluationRepository.findById(id);
        if (existingEvaluation.isPresent()) {
            EmploymentEvaluation updatedEvaluation = existingEvaluation.get();
            updatedEvaluation.setEmployeeName(evaluation.getEmployeeName());
            updatedEvaluation.setEvaluatorName(evaluation.getEvaluatorName());
            updatedEvaluation.setEvaluationDate(evaluation.getEvaluationDate());
            updatedEvaluation.setComments(evaluation.getComments());
            updatedEvaluation.setScore(evaluation.getScore());
            updatedEvaluation.setOverallRating(evaluation.getOverallRating());
            updatedEvaluation.setStatus(evaluation.getStatus());
            return employmentEvaluationRepository.save(updatedEvaluation);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEmploymentEvaluation(Long id) {
        employmentEvaluationRepository.deleteById(id);
    }

    @Override
    public EmploymentEvaluation getEmploymentEvaluationById(Long id) {
        return employmentEvaluationRepository.findById(id).orElse(null);
    }

    @Override
    public List<EmploymentEvaluation> getAllEmploymentEvaluations() {
        return employmentEvaluationRepository.findAll();
    }

    // === Post Methods ===
    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post updatedPost) {
        Optional<Post> existingPost = postRepository.findById(id);
        if (existingPost.isPresent()) {
            Post post = existingPost.get();
            post.setCode(updatedPost.getCode());
            post.setVersion(updatedPost.getVersion());
            post.setDate(updatedPost.getDate());
            post.setDesignation(updatedPost.getDesignation());
            post.setInterim(updatedPost.getInterim());
            post.setFormations(updatedPost.getFormations());
            post.setExperiences(updatedPost.getExperiences());
            post.setContraintesTechniques(updatedPost.getContraintesTechniques());
            post.setContraintesMetiers(updatedPost.getContraintesMetiers());
            post.setDelais(updatedPost.getDelais());
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // === EducationalRessources Methods ===
    @Override
    public EducationalRessources addResource(EducationalRessources resource) {
        return educationalRessourcesRepository.save(resource);
    }

    @Override
    public EducationalRessources updateResource(Long id, EducationalRessources updatedResource) {
        Optional<EducationalRessources> existingResource = educationalRessourcesRepository.findById(id);
        if (existingResource.isPresent()) {
            EducationalRessources resource = existingResource.get();
            resource.setTitle(updatedResource.getTitle());
            resource.setDescription(updatedResource.getDescription());
            resource.setType(updatedResource.getType());
            resource.setUrl(updatedResource.getUrl());
            resource.setAuthor(updatedResource.getAuthor());
            resource.setCreationDate(updatedResource.getCreationDate());
            resource.setDuration(updatedResource.getDuration());
            resource.setDifficultyLevel(updatedResource.getDifficultyLevel());
            resource.setLanguage(updatedResource.getLanguage());
            resource.setRating(updatedResource.getRating());
            return educationalRessourcesRepository.save(resource);
        } else {
            return null;
        }
    }

    @Override
    public void deleteResource(Long id) {
        educationalRessourcesRepository.deleteById(id);
    }

    @Override
    public EducationalRessources getResourceById(Long id) {
        return educationalRessourcesRepository.findById(id).orElse(null);
    }

    @Override
    public List<EducationalRessources> getAllResources() {
        return educationalRessourcesRepository.findAll();
    }


    // === Certification Methods ===
    @Override
    public Certification addCertification(Certification certification) {
        return certificationRepository.save(certification);
    }

    @Override
    public Certification updateCertification(Long id, Certification certification) {
        Optional<Certification> existingCertification = certificationRepository.findById(id);
        if (existingCertification.isPresent()) {
            Certification updatedCertification = existingCertification.get();
            updatedCertification.setName(certification.getName());
            updatedCertification.setDescription(certification.getDescription());
            updatedCertification.setIssueDate(certification.getIssueDate());
            updatedCertification.setExpiryDate(certification.getExpiryDate());
            updatedCertification.setIssuedBy(certification.getIssuedBy());
            return certificationRepository.save(updatedCertification);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCertification(Long id) {
        certificationRepository.deleteById(id);
    }

    @Override
    public Certification getCertificationById(Long id) {
        return certificationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    // === OperationTask Methods ===
    @Override
    public OperationTask addOperationTask(OperationTask operationTask) {
        return operationTaskRepository.save(operationTask);
    }

    @Override
    public OperationTask updateOperationTask(Long id, OperationTask operationTask) {
        Optional<OperationTask> existingOperationTask = operationTaskRepository.findById(id);
        if (existingOperationTask.isPresent()) {
            OperationTask updatedOperationTask = existingOperationTask.get();
            updatedOperationTask.setName(operationTask.getName());
            updatedOperationTask.setDescription(operationTask.getDescription());
            updatedOperationTask.setStartDate(operationTask.getStartDate());
            updatedOperationTask.setEndDate(operationTask.getEndDate());
            updatedOperationTask.setDeadline(operationTask.getDeadline());
            updatedOperationTask.setStatus(operationTask.getStatus());
            return operationTaskRepository.save(updatedOperationTask);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOperationTask(Long id) {
        operationTaskRepository.deleteById(id);
    }

    @Override
    public OperationTask getOperationTaskById(Long id) {
        return operationTaskRepository.findById(id).orElse(null);
    }

    @Override
    public List<OperationTask> getAllOperationTasks() {
        return operationTaskRepository.findAll();
    }
    // === candidate evaluation Methods ===
    @Override
    public CandidateEvaluation addCandidateEvaluation(CandidateEvaluation candidateEvaluation) {
        return candidateEvaluationRepository.save(candidateEvaluation);
    }

    @Override
    public CandidateEvaluation updateCandidateEvaluation(Long id, CandidateEvaluation candidateEvaluation) {
        Optional<CandidateEvaluation> existingEvaluation = candidateEvaluationRepository.findById(id);
        if (existingEvaluation.isPresent()) {
            CandidateEvaluation updatedEvaluation = existingEvaluation.get();
            updatedEvaluation.setCandidateId(candidateEvaluation.getCandidateId());
            updatedEvaluation.setJobOfferId(candidateEvaluation.getJobOfferId());
            updatedEvaluation.setEvaluatorId(candidateEvaluation.getEvaluatorId());
            updatedEvaluation.setEvaluationDate(candidateEvaluation.getEvaluationDate());
            updatedEvaluation.setComments(candidateEvaluation.getComments());
            updatedEvaluation.setRating(candidateEvaluation.getRating());
            updatedEvaluation.setPost(candidateEvaluation.getPost());
            return candidateEvaluationRepository.save(updatedEvaluation);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCandidateEvaluation(Long id) {
        candidateEvaluationRepository.deleteById(id);
    }

    @Override
    public CandidateEvaluation getCandidateEvaluationById(Long id) {
        return candidateEvaluationRepository.findById(id).orElse(null);
    }

    @Override
    public List<CandidateEvaluation> getAllCandidateEvaluations() {
        return candidateEvaluationRepository.findAll();
    }
}

