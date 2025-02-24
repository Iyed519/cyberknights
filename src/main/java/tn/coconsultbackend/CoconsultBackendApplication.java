package tn.coconsultbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import tn.coconsultbackend.role.Role;
import tn.coconsultbackend.role.RoleRepository;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class CoconsultBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoconsultBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName("USER").isEmpty()){
                roleRepository.save(
                        Role.builder().name("USER").build()
                );
            }
        };
    }
}
