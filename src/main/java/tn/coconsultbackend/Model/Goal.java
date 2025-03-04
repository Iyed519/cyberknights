package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGoal;
    private String goalCode;
    private String goalDescription;
    @Enumerated(EnumType.STRING)
    private Axe axe;
}
