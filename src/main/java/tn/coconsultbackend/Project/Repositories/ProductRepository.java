package tn.coconsultbackend.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.coconsultbackend.Model.Product;
import tn.coconsultbackend.Model.Project;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
