package com.furama.service;

import com.furama.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IContractService {
    List<Contract> findAll();
    Contract selectContractById(int id);
    Page<Contract> findAllWithPage(Pageable pageable);

    Page<Contract> searchContract(String searchData, Pageable pageable);

    Contract saveAndFlush(Contract contract);

    Contract save(Contract contract);

    void deleteById(int id);
}
