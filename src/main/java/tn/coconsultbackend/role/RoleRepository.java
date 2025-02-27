package tn.coconsultbackend.role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name); // melakher optional haja safe bch matjickch NPE : null pointer exception traja3lk type hadheka li houwa role wala optiona.empty li hiya fergha
}
