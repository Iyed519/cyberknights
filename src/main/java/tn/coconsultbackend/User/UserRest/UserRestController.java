package tn.coconsultbackend.User.UserRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.DTO.LoginRequest;
import tn.coconsultbackend.DTO.LoginResponse;
import tn.coconsultbackend.DTO.UserRegistrationRequest;
import tn.coconsultbackend.User.UserServices.UserService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserRestController {

   @Autowired
   private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        String result = userService.registerUser(registrationRequest).toString();
        return ResponseEntity.ok().body(Map.of("message", result)); // Return JSON: {"message": "User registered successfully."}
    }
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }
    @GetMapping("/admin-only")
    public String adminOnlyRoute() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return String.format("Hello %s! This route is accessible by ADMIN only.", username);
    }

}
