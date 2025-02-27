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
public class EmploymentEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee name cannot be blank")
    private String employeeName;

    @NotBlank(message = "Evaluator name cannot be blank")
    private String evaluatorName;

    @NotBlank(message = "Evaluation date cannot be blank")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Evaluation date must be in the format yyyy-MM-dd")
    private String evaluationDate; // Ensure format "yyyy-MM-dd"

    private String comments;

    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 10, message = "Score must be at most 10")
    private Long score; // Score in the range 1-10

    @Min(value = 1, message = "Overall rating must be at least 1")
    @Max(value = 5, message = "Overall rating must be at most 5")
    private Integer overallRating; // Overall rating in the range 1-5

    @NotNull(message = "Status cannot be null")
    @Enumerated(EnumType.STRING)
    private Status status;
}
