package com.furama.repository;

import com.furama.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDao  {

    @PersistenceContext
    private EntityManager entityManager;

    public List dynamicQuery (String query){
        Query q = entityManager.createNativeQuery(query, Customer.class);
//        TypedQuery<Customer> searchResult = q.getResultList();
        return q.getResultList();
    }
}
