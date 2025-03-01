package tn.coconsultbackend.TrainingManagement;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingContent  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotBlank
    private String name;
    @NotEmpty
    @NotBlank
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;


    @NotEmpty
    @NotBlank
    private String contentUrl;

    @ManyToOne
    private TrainingLevel trainingLevel;

}

