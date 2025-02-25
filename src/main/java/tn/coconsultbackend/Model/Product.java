package tn.coconsultbackend.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProduct;

    @Column(nullable = false)
    String name;

    @Column(nullable = true)
    String description;

    @Column(nullable = false)
    Double price;

    @Column(nullable = false)
    Integer quantityInStock;
    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }
}
