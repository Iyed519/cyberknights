package tn.coconsultbackend.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tn.coconsultbackend.user.User;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;
    @CreatedDate
    @Column(nullable = false, updatable = false) // we want to keep track where this entity was created but we don't want to update that colomun if we update the entity
    private LocalDateTime createdDate;
    @LastModifiedDate //@LastModifiedDate automatically sets lastModifiedDate only when the entity is updated.
    @Column(insertable = false) // when we create a new record we don't want to initialize the value of this attribut: The insertable = false attribute in the @Column annotation prevents the column from being included in the SQL INSERT statement when a new record is created.
    private LocalDateTime lastModifiedDate;


}
