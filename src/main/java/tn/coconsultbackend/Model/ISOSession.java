package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ISOSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    private Integer year;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private SessionStatus status; // Active, Completed, Archived
    private String createdBy; // User who initiated the session

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Process> processes; // List of processes activated in this session

    @OneToMany(mappedBy = "session")
    private List<Audit> audits; // Audits performed during this session

    @OneToMany(mappedBy = "session")
    private List<Indicator> indicators; // KPIs evaluated in this session

    @OneToMany(mappedBy = "session")
    private List<NonConformanceReport> nonConformanceReports; // Non-conformances identified

}
