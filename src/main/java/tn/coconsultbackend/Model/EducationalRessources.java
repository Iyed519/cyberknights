package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class EducationalRessources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 10, message = "Description must be at least 10 characters")
    private String description;

    @NotBlank(message = "Type cannot be blank")
    @Size(min = 3, max = 50, message = "Type must be between 3 and 50 characters")
    private String type;

    @NotBlank(message = "URL cannot be blank")
    @Pattern(regexp = "^(http://|https://).+", message = "Invalid URL format")
    private String url;

    @NotBlank(message = "Author cannot be blank")
    @Size(min = 3, max = 100, message = "Author must be between 3 and 100 characters")
    private String author;

    @NotNull(message = "Creation date cannot be null")
    @PastOrPresent(message = "Creation date must be in the past or present")
    private LocalDate creationDate;

    @NotBlank(message = "Duration cannot be blank")
    private String duration;

    @NotBlank(message = "Difficulty level cannot be blank")
    @Size(min = 3, max = 20, message = "Difficulty level must be between 3 and 20 characters")
    private String difficultyLevel;

    @NotBlank(message = "Language cannot be blank")
    private String language;

    @DecimalMin(value = "0.0", message = "Rating must be at least 0.0")
    @DecimalMax(value = "5.0", message = "Rating must be at most 5.0")
    private Double rating;

}
