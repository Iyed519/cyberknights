//package tn.coconsultbackend.User;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import tn.coconsultbackend.Model.Audit;
//import tn.coconsultbackend.Roles.Role;
//
//import java.security.Principal;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static jakarta.persistence.FetchType.EAGER;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class User implements UserDetails, Principal {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String firstname;
//    private String lastname;
//    private LocalDate dateOfBirth;
//    @Column(unique = true)
//    private String email;
//    private String password;
//    private boolean accountLocked;
//    private boolean enabled;
//
//    @ManyToMany(fetch = EAGER)
//    private List<Role> roles;
//
//    @OneToOne(fetch = EAGER)
//     private Audit auditor;
//
//    @CreatedDate
//    @Column(nullable = false, updatable = false)
//    private LocalDateTime createdDate;
//
//    @LastModifiedDate
//    @Column(insertable = false)
//    private LocalDateTime lastModifiedDate;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.roles
//                .stream()
//                .map(r -> new SimpleGrantedAuthority(r.getName()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public String getUsername() {
//        return "";
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
//    }
//
//
//    @Override
//    public String getName() {
//        return "";
//    }
//}
