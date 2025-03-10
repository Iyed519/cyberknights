package tn.coconsultbackend.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty (message = "First Name is mandatory")
    @NotBlank (message = "First Name is mandatory")
    private String firstname;

    @NotEmpty (message = "Last Name is mandatory")
    @NotBlank (message = "Last Name is mandatory")
    private String lastname;

    @Email (message = "email is not formatted : name@exemple.com")
    @NotEmpty (message = "email is mandatory")
    @NotBlank (message = "email is mandatory")
    private String email;

    @NotEmpty (message = "password is mandatory")
    @NotBlank (message = "password is mandatory")
    @Size (min= 8, message = "Password should be 8 characters long minimum")
    private String password;


}
