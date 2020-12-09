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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @Column(name = "pass_word")
    String passWord;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    List<Cart> cartList;

    String address;

    boolean remember = false;

    public Cart getUnpaidCart(){
        for (Cart cart: this.getCartList()) {
            if(!cart.paid) {
                return cart;
            }
        } this.getCartList().add(new Cart(null, this, new ArrayList<>(),false));
        return this.getCartList().get(this.getCartList().size()-1);
    }

    public Customer(Integer id, String name, String passWord, List<Cart> cartList, String address, boolean remember) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.cartList = cartList;
        this.address = address;
        this.remember = remember;
    }

    public Customer() {
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
