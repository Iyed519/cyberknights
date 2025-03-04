package tn.coconsultbackend.QualityManagementProcess.RestController;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rest")
public class QualityManagementProcessRestController {

//    @GetMapping
//    @PreAuthorize("hasRole('client_user')")
//    public String getQualityManagementProcess() {
//        return "Quality Management Process";
//    }
//
//    @GetMapping("/hello-2")
//    @PreAuthorize("hasRole('client_admin')")
//    public String hello2() {
//        return "Hello from Spring boot & Keycloak - ADMIN";
//    }
}
