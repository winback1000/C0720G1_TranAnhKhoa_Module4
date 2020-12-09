package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    List<CartProduct> cardProductList;

    public double getTotalCost(){
        double totalCost = 0;
        for (CartProduct cardProduct: this.cardProductList) {
            totalCost = totalCost+(cardProduct.product.getPrice()*cardProduct.getQuantity());
        }
        return totalCost;
    }

    boolean paid = false;
}
