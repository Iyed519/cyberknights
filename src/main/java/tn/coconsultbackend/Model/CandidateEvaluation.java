package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Candidate ID cannot be null")
    private Long candidateId;

    @NotNull(message = "Job Offer ID cannot be null")
    private Long jobOfferId;

    @NotNull(message = "Evaluator ID cannot be null")
    private Long evaluatorId;

    @NotBlank(message = "Evaluation date cannot be blank")
    private String evaluationDate;

    @Size(max = 500, message = "Comments cannot exceed 500 characters")
    private String comments;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private int rating;

    @NotNull(message = "Status cannot be null")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Post post;
}