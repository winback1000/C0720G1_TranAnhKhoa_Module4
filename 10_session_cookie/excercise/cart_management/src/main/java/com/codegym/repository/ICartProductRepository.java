package com.codegym.repository;

import com.codegym.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartProductRepository extends JpaRepository<CartProduct,Integer> {
}
