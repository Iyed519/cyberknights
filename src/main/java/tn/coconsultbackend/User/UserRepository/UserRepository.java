package tn.coconsultbackend.User.UserRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.User.Model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    Optional<Object> findByEmail(String email);
}