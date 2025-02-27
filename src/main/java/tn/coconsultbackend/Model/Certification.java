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
@AllArgsConstructor
@NoArgsConstructor
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Certification name cannot be blank")
    private String name;  // Name of the certification (e.g., "Java Developer Certification")

    private String description;  // A short description of the certification

    @NotNull(message = "Issue date cannot be null")
    @PastOrPresent(message = "Issue date must be in the past or present")
    private LocalDate issueDate;

    @NotNull(message = "Expiry date cannot be null")
    @FutureOrPresent(message = "Expiry date must be in the future or present")
    private LocalDate expiryDate;

    @NotBlank(message = "Issuer cannot be blank")
    private String issuedBy;

    @ManyToMany(mappedBy = "certifications")
    private List<Training> trainings;

    @ManyToMany(mappedBy = "certifications")
    private List<Post> posts;

}
