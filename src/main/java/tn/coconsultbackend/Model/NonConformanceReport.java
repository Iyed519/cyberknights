package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NonConformanceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ncr_id;
    private String reportNumber;
    private String description;
    @Enumerated(EnumType.STRING)
    private Severity severity;
    @Enumerated(EnumType.STRING)
    private NonConformanceStatus status;
    private LocalDate reported_at;
    private String reportedBy;

    @ManyToOne
    private Project project;

    @ManyToOne
    private ISOSession session;

}
