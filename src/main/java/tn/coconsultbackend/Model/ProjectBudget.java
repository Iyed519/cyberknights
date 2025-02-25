package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectBudget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProjectBudget;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    Project project;

    @Column(nullable = false)
    Double initialBudget;

    @Column(nullable = false)
    Double currentBudget;

    @Column(nullable = false)
    Double spentBudget;

    @Column(nullable = false)
    Date lastUpdated;
    public void setIdProjectBudget(Long idProjectBudget) {
        this.idProjectBudget = idProjectBudget;
    }


}
