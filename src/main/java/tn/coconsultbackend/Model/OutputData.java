package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OutputData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int outputId;
    private String output;

    @ManyToOne
    private Operation operationOut;
}
