package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String image;
    double price;
    @Column(columnDefinition = "LONGTEXT")
    String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
            @JsonBackReference
    List<CartProduct> cartProductList;

    public String getShortDescription() {
        if (this.description.length()< 40) {
            return this.description;
        } else {
            return this.description.substring(0,40).concat(".....");
        }
    }
}
