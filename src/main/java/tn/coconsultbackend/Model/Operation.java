package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long opId;
    private String opCode;
    private String opDescription;

    @OneToOne(mappedBy = "operation", fetch = FetchType.EAGER)
    private Post post;

    @OneToMany(mappedBy = "operation", fetch = FetchType.EAGER)
    private List<OperationTask> tasks;
}
