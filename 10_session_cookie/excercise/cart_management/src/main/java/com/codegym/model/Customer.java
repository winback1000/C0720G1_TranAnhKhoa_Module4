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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @Column(name = "pass_word")
    String passWord;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonBackReference
    List<Cart> cartList = new ArrayList<>();

    String address;

    boolean remember = false;

    public Cart getUnpaidCart(){
        for (Cart cart: cartList) {
            if(!cart.paid) {
                return cart;
            }
        } cartList.add(new Cart(null, this, new ArrayList<>(),false));
        return cartList.get(cartList.size()-1);
    }
}
