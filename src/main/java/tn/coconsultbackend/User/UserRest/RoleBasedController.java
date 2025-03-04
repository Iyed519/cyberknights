package tn.coconsultbackend.User.UserRest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

public class RoleBasedController {
    @GetMapping("/admin-only")
    public String adminOnlyRoute(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return String.format("Hello %s! This route is accessible by ADMIN only !!!", username);
    }

    @GetMapping("/admin-user")
    public String adminAndUserRoute() {
        Authentication authenfification = SecurityContextHolder.getContext().getAuthentication();
        String username = authenfification.getName();

        return String.format("Hello %s! this route is accessible by ADMIN and USER :)", username);
    }
}
