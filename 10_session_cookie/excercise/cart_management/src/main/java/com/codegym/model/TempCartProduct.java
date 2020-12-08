package com.codegym.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TempCartProduct {
    int productId;
    String name;
    String image;
    double price;
    int quantity;
}
