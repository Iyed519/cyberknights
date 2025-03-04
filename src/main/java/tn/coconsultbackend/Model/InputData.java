package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InputData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inputId;
    private String input;

    @ManyToOne
    private Operation operationIn;
}
