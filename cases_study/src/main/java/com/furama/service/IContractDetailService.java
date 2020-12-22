package com.furama.service;

import com.furama.entity.AttachService;
import com.furama.entity.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();
    ContractDetail selectContractDetailById(int id);

    void save(ContractDetail contractDetail);

    void deleteAllByContractId(Integer id);
}
