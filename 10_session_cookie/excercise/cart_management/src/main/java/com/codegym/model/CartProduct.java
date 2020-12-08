package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.smartcardio.Card;
import java.io.Serializable;

@Entity(name = "card_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartProduct{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;

    int quantity;
}
