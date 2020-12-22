package com.codegym.repository;

import com.codegym.entity.Purchasing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasingRepository extends JpaRepository<Purchasing, Integer> {

    List<Purchasing> findAllByServiceTypeContainingAndCustomer_NameContaining(String serviceType, String customerName);
}
