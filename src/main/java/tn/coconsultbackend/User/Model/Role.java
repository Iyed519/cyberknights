package tn.coconsultbackend.User.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public static final String FRONTEND_DEVELOPER = "FRONTEND_DEVELOPER";
    public static final String BACKEND_DEVELOPER = "BACKEND_DEVELOPER";
    public static final String ADMIN = "ADMIN";

    @ManyToOne
    private User user;

    public Role(String frontendDeveloper) {

    }
}