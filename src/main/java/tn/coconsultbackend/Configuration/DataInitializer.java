package tn.coconsultbackend.Configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tn.coconsultbackend.User.Model.Role;
import tn.coconsultbackend.User.Model.User;
import tn.coconsultbackend.User.UserRepository.UserRepository;

import java.util.List;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        // Seed admin user
        if (userRepository.findByName("admin").isEmpty()) {
            Role adminRole = new Role("ADMIN");
            User admin = new User("admin", passwordEncoder.encode("admin123"), List.of(adminRole));
            userRepository.save(admin);
        }

        // Seed regular user
        if (userRepository.findByName("user").isEmpty()) {
            Role userRole = new Role("USER");
            User user = new User("user", passwordEncoder.encode("user123"), List.of(userRole));
            userRepository.save(user);
        }
    }
}