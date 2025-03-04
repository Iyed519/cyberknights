package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int opTaskId;
    private String opTaskName;
    private String opTaskDescription;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Operation operation;
}
