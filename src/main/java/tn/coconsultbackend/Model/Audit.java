package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;
import tn.coconsultbackend.User.Model.User;


import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long auditId;
    private String scope;
    private LocalDate audit_date;
    @Enumerated(EnumType.STRING)
    private AuditStatus auditStatus;

    @OneToOne(mappedBy = "auditor")
    private User user;

    @ManyToOne
    private ISOSession session;
}
