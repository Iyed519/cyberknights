package tn.coconsultbackend.User.UserRepository;



import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.User.Model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}