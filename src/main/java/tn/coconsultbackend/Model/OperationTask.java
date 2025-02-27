package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "operation_task")
@AllArgsConstructor
@NoArgsConstructor
public class OperationTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Task name cannot be blank")
    private String name;  // Task name (e.g., "Develop Application Feature")

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Start date cannot be null")
    @PastOrPresent(message = "Start date must be in the past or present")
    private LocalDate startDate;

    @NotNull(message = "End date cannot be null")
    @FutureOrPresent(message = "End date must be in the future or present")
    private LocalDate endDate;

    @NotNull(message = "Deadline cannot be null")
    @Future(message = "Deadline must be in the future")
    private LocalDate deadline;

    @NotNull(message = "Status cannot be null")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; // Each task is linked to one post
}
