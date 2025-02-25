package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProject;
    Long indicatorId;

    @ManyToOne
    @JoinColumn(name = "report_id")
    PerformanceReport performanceReport;

    String name;
    Double value;
    String description;
    public void setIndicatorId(Long indicatorId) {
        this.indicatorId = indicatorId;
    }
}
