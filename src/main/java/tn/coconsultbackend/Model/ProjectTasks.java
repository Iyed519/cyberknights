package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProjectTasks;

    @ManyToOne
    @JoinColumn(name = "project_id")
    Project project;

    @ManyToOne
    @JoinColumn(name = "milestone_id", nullable = true)
    Milestone milestone;

    String name;
    String description;
    String assignedTo;
    Date startDate;
    Date endDate;
    String status; // not started, in-progress, completed

    @ElementCollection
    List<String> resourcesAllocated;

    Boolean deliverableValidated;
    public void setIdProjectTasks(Long idProjectTasks) {
        this.idProjectTasks = idProjectTasks;
    }
}
