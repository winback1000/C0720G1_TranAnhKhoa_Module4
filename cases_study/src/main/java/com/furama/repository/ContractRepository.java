package com.furama.repository;

import com.furama.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select contract.* from contract " +
            "join customer on contract.customer_id = customer.id " +
            "join employee on contract.employee_id = employee.id " +
            "join service on contract.service_id = service.id " +
            "where customer.name like ?1 or employee.name like ?2 or service.name like ?3", nativeQuery = true)
    Page<Contract> findAllByCustomer_NameOrEmployee_NameOrService_Name(String nameCustomer, String nameEmployee, String nameService, Pageable pageable);

//    Page<Contract> findAllBySta

}
