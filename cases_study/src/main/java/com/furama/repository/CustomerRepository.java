package com.furama.repository;

import com.furama.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameContainsOrEmailContains(String name, String email, Pageable pageable);

//    @Query(value = "?1", nativeQuery = true)
//    Page<Customer> CustomSearch(String query, Pageable pageable);

}
