package tn.coconsultbackend.User.UserServices;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.Configuration.JwtUtils;
import tn.coconsultbackend.DTO.LoginRequest;
import tn.coconsultbackend.DTO.LoginResponse;
import tn.coconsultbackend.DTO.UserRegistrationRequest;
import tn.coconsultbackend.User.Model.Role;
import tn.coconsultbackend.User.Model.User;
import tn.coconsultbackend.User.UserRepository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public Map<String, String> registerUser(UserRegistrationRequest request) { // Return Map for JSON
        if (userRepository.findByName(request.getUsername()).isPresent()) {
            return Map.of("message", "Username is already taken.");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return Map.of("message", "Email is already in use.");
        }
        List<Role> roles = Arrays.asList(new Role(Role.FRONTEND_DEVELOPER));
        User user = new User(request.getUsername(), request.getPassword(), request.getEmail(), roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return Map.of("message", "User registered successfully.");
    }

    public LoginResponse loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByName(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password."));
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password.");
        }
        List<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList());
        String token = jwtUtils.generateToken(user.getUsername(), roles); // Pass roles to generateToken
        return new LoginResponse(token);
    }
}