package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonBackReference
    List<CartProduct> cardProductList = new ArrayList<>();

    public double getTotalCost(){
        double totalCost = 0;
        for (CartProduct cardProduct: cardProductList) {
            totalCost = totalCost+(cardProduct.product.getPrice()*cardProduct.getQuantity());
        }
        return totalCost;
    }

    boolean paid = false;
}
