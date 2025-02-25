package tn.coconsultbackend.Project.Services;

import tn.coconsultbackend.Model.Product;

import java.util.List;
import java.util.Optional;

public interface IProduct {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
}
