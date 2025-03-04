//package tn.coconsultbackend.Roles;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import tn.coconsultbackend.User.Model.User;
//
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class Role {
//    @Id
//    @GeneratedValue
//    private Long roleId;
//    @Column(unique = true)
//    private String name;
//
//    @ManyToMany(mappedBy = "roles")
//    @JsonIgnore
//    private List<User> user;
//
//    @CreatedDate
//    @Column(nullable = false, updatable = false)
//    private LocalDateTime createdDate;
//
//    @LastModifiedDate
//    @Column(insertable = false)
//    private LocalDateTime lastModifiedDate;
//}
