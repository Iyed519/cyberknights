package tn.coconsultbackend.HumanRessourcesProcess.RestController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import tn.coconsultbackend.HumanRessourcesProcess.Services.IHumanRessourcesProcessService;
import tn.coconsultbackend.Model.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("hr")
public class HumanRessourcesProcessRestController {

        @Autowired
        private IHumanRessourcesProcessService humanRessourcesProcessService;

        // === Training Endpoints ===

        @PostMapping("addTraining")
        Training addTraining(@Valid @RequestBody Training training) {
            return humanRessourcesProcessService.addTraining(training);
        }

        @PutMapping("updateTraining/{id}")
        Training updateTraining(@PathVariable Long id,@Valid @RequestBody Training training) {
            return humanRessourcesProcessService.updateTraining(id, training);
        }

        @DeleteMapping("deleteTraining/{id}")
        void deleteTraining(@PathVariable Long id) {
            humanRessourcesProcessService.deleteTraining(id);
        }

        @GetMapping("getTrainingById/{id}")
        Training getTrainingById(@PathVariable Long id) {
            return humanRessourcesProcessService.getTrainingById(id);
        }

        @GetMapping("getAllTrainings")
        List<Training> getAllTrainings() {
            return humanRessourcesProcessService.getAllTrainings();
        }

        // === EmploymentEvaluation Endpoints ===

        @PostMapping("addEmploymentEvaluation")
        EmploymentEvaluation addEmploymentEvaluation(@Valid @RequestBody EmploymentEvaluation evaluation) {
            return humanRessourcesProcessService.addEmploymentEvaluation(evaluation);
        }

        @PutMapping("updateEmploymentEvaluation/{id}")
        EmploymentEvaluation updateEmploymentEvaluation(@PathVariable Long id,@Valid @RequestBody EmploymentEvaluation evaluation) {
            return humanRessourcesProcessService.updateEmploymentEvaluation(id, evaluation);
        }

        @DeleteMapping("deleteEmploymentEvaluation/{id}")
        void deleteEmploymentEvaluation(@PathVariable Long id) {
            humanRessourcesProcessService.deleteEmploymentEvaluation(id);
        }

        @GetMapping("getEmploymentEvaluationById/{id}")
        EmploymentEvaluation getEmploymentEvaluationById(@PathVariable Long id) {
            return humanRessourcesProcessService.getEmploymentEvaluationById(id);
        }

        @GetMapping("getAllEmploymentEvaluations")
        List<EmploymentEvaluation> getAllEmploymentEvaluations() {
            return humanRessourcesProcessService.getAllEmploymentEvaluations();
        }

        // === Post Endpoints ===

        @PostMapping("addPost")
        Post addPost(@Valid @RequestBody Post post) {
            return humanRessourcesProcessService.addPost(post);
        }

        @GetMapping("getPostById/{id}")
        Post getPostById(@PathVariable Long id) {
            return humanRessourcesProcessService.getPostById(id);
        }

        @GetMapping("getAllPosts")
        List<Post> getAllPosts() {
            return humanRessourcesProcessService.getAllPosts();
        }

        @PutMapping("updatePost/{id}")
        Post updatePost(@PathVariable Long id,@Valid @RequestBody Post updatedPost) {
            return humanRessourcesProcessService.updatePost(id, updatedPost);
        }

        @DeleteMapping("deletePost/{id}")
        void deletePost(@PathVariable Long id) {
            humanRessourcesProcessService.deletePost(id);
        }

        // === Certification Endpoints ===

        @PostMapping("addCertification")
        Certification addCertification(@Valid @RequestBody Certification certification) {
            return humanRessourcesProcessService.addCertification(certification);
        }

        @GetMapping("getCertificationById/{id}")
        Certification getCertificationById(@PathVariable Long id) {
            return humanRessourcesProcessService.getCertificationById(id);
        }

        @GetMapping("getAllCertifications")
        List<Certification> getAllCertifications() {
            return humanRessourcesProcessService.getAllCertifications();
        }

        @PutMapping("updateCertification/{id}")
        Certification updateCertification(@PathVariable Long id,@Valid @RequestBody Certification updatedCertification) {
            return humanRessourcesProcessService.updateCertification(id, updatedCertification);
        }

        @DeleteMapping("deleteCertification/{id}")
        void deleteCertification(@PathVariable Long id) {
            humanRessourcesProcessService.deleteCertification(id);
        }

        // === EducationalRessources Endpoints ===

        @PostMapping("addEducationalRessource")
        EducationalRessources addEducationalRessource(@Valid @RequestBody EducationalRessources resource) {
            return humanRessourcesProcessService.addResource(resource);
        }

        @GetMapping("getAllEducationalRessources")
        List<EducationalRessources> getAllEducationalRessources() {
            return humanRessourcesProcessService.getAllResources();
        }

        @GetMapping("getRessourceById/{id}")
        EducationalRessources getRessourceById(@PathVariable Long id) {
            return humanRessourcesProcessService.getResourceById(id);
        }

        @PutMapping("updateEducationalRessource/{id}")
        EducationalRessources updateEducationalRessource(@PathVariable Long id,@Valid @RequestBody EducationalRessources updatedResource) {
            return humanRessourcesProcessService.updateResource(id, updatedResource);
        }

        @DeleteMapping("deleteEducationalRessource/{id}")
        void deleteEducationalRessource(@PathVariable Long id) {
            humanRessourcesProcessService.deleteResource(id);
        }


        // === OperationTask Endpoints ===

        @PostMapping("/addOperationTask")
        OperationTask addOperationTask(@Valid @RequestBody OperationTask operationTask) {
            return humanRessourcesProcessService.addOperationTask(operationTask);
        }

        @PutMapping("/updateOperationTask/{id}")
        OperationTask updateOperationTask(@PathVariable Long id, @Valid @RequestBody OperationTask operationTask) {
            return humanRessourcesProcessService.updateOperationTask(id, operationTask);
        }

        @DeleteMapping("/deleteOperationTask/{id}")
        void deleteOperationTask(@PathVariable Long id) {
            humanRessourcesProcessService.deleteOperationTask(id);
        }

        @GetMapping("/getOperationTaskById/{id}")
        OperationTask getOperationTaskById(@PathVariable Long id) {
            return humanRessourcesProcessService.getOperationTaskById(id);
        }

        @GetMapping("/getAllOperationTasks")
        List<OperationTask> getAllOperationTasks() {
            return humanRessourcesProcessService.getAllOperationTasks();
        }

        // === CandidateEvaluation Endpoints ===

        @PostMapping("/addCandidateEvaluation")
        CandidateEvaluation addCandidateEvaluation(@Valid @RequestBody CandidateEvaluation candidateEvaluation) {
            return humanRessourcesProcessService.addCandidateEvaluation(candidateEvaluation);
        }

        @PutMapping("updateCandidateEvaluation/{id}")
        CandidateEvaluation updateCandidateEvaluation(@PathVariable Long id,@Valid @RequestBody CandidateEvaluation candidateEvaluation) {
            return humanRessourcesProcessService.updateCandidateEvaluation(id, candidateEvaluation);
        }

        @DeleteMapping("deleteCandidateEvaluation/{id}")
        void deleteCandidateEvaluation(@PathVariable Long id) {
            humanRessourcesProcessService.deleteCandidateEvaluation(id);
        }

        @GetMapping("getCandidateEvaluationById/{id}")
        CandidateEvaluation getCandidateEvaluationById(@PathVariable Long id) {
            return humanRessourcesProcessService.getCandidateEvaluationById(id);
        }

        @GetMapping("getAllCandidateEvaluations")
        List<CandidateEvaluation> getAllCandidateEvaluations() {
            return humanRessourcesProcessService.getAllCandidateEvaluations();
        }
    }