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
public class PerformanceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long reportId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    Project project;

    Date reportDate;
    String reportType; // monthly, annual
    Integer technicalErrorsDetected;
    Double deadlineComplianceRate; // Percentage

    @OneToMany(mappedBy = "performanceReport", cascade = CascadeType.ALL)
    List<Indicator> indicators;
    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }
}

