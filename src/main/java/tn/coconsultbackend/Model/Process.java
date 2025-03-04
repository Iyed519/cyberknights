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
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProcess;
    @Enumerated(EnumType.STRING)
    private ProcessType processType;

    @ManyToOne
    private ISOSession session;
}

