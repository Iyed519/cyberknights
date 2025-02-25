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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProject;
    String projectName;
    String description;
    Date startDate;
    Date endDate;
    String status;//planned, in-progress, completed
    Double budget;
    String client;
    String manager;

    @ElementCollection
    List<String> teamMembers;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    List<Milestone> milestones;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    List<ProjectTasks> tasks;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    List<PerformanceReport> performanceReports;
    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }


}
