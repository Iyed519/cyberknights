package tn.coconsultbackend.DTO;

import java.util.Set;

public class UserRegistrationRequest {
     String username;
     String password;
    private String email;
     Set<String> roles;
    public UserRegistrationRequest() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }

}
