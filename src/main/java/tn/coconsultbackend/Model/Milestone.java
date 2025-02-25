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
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long milestoneId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    Project project;

    String name;
    String description;
    Date startDate;
    Date endDate;
    String status; // not started, in-progress, completed
    public void setMilestoneId(Long milestoneId) {
        this.milestoneId = milestoneId;
    }
}
