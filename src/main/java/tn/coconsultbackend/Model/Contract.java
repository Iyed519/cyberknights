package tn.coconsultbackend.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import tn.coconsultbackend.CustomerOperationProcess.Repositories.ContractRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String contractNumber;

    private LocalDate startDate;

    private String status;

    private double amount;


    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Complaint> complaints;


}
