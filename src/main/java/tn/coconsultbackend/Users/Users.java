package tn.coconsultbackend.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password; // Géré par Keycloak

    @Column(unique = true, nullable = false)
    private String email;

    private String firstName;
    private String lastName;
    private boolean isActive = true;
    private LocalDateTime lastLogin;
    private LocalDateTime profileUpdatedAt;

    @Enumerated(EnumType.STRING)
    private Role role; // Ex. CLIENT, ADMIN

    // Getters and Setters
}
