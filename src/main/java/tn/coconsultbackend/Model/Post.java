package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Code cannot be null")
    @Pattern(regexp = "^[A-Z]{3}-[A-Z]{2}-\\d{2}$", message = "Invalid code format (e.g., FCH-RH-02)")
    private String code; // e.g., FCH-RH-02

    @NotNull(message = "Version cannot be null")
    @Pattern(regexp = "^\\d{2}$", message = "Invalid version format (e.g., 00)")
    private String version; // e.g., 00

    @NotNull(message = "Date cannot be null")
    @PastOrPresent(message = "Date must be in the past or present")
    private LocalDate date;

    @NotBlank(message = "Designation cannot be blank")
    private String designation; // e.g., Responsable Réalisation Technique

    @NotBlank(message = "Interim cannot be blank")
    private String interim; // e.g., Ingénieur Développeur

    @NotBlank(message = "Formations cannot be blank")
    private String formations; // e.g., Développement des applications informatiques

    @NotBlank(message = "Experiences cannot be blank")
    private String experiences; // e.g., 5 ans d'expérience en développement

    @NotBlank(message = "Contraintes techniques cannot be blank")
    private String contraintesTechniques; // e.g., systèmes d'exploitation, configuration réseau

    @NotBlank(message = "Contraintes métiers cannot be blank")
    private String contraintesMetiers; // e.g., réglementation légale, méthodologie de travail

    @NotBlank(message = "Delais cannot be blank")
    private String delais; // e.g., Délais de mise en oeuvre souhaités

    @OneToMany(mappedBy = "post")
    private List<OperationTask> operationTasks;

    @OneToMany(mappedBy = "post")
    private List<User> users; // Employees assigned to this post

    @OneToMany(mappedBy = "post")
    private List<CandidateEvaluation> candidateEvaluations;

    @ManyToMany
    private  List<Certification> certifications;
}
