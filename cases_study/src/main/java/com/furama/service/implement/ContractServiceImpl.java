package com.furama.service.implement;

import com.furama.entity.Contract;
import com.furama.repository.ContractRepository;
import com.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract selectContractById(int id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> findAllWithPage(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> searchContract(String searchData, Pageable pageable) {
        return contractRepository.findAllByCustomer_NameOrEmployee_NameOrService_Name("%"+searchData+"%","%"+searchData+"%","%"+searchData+"%",pageable);
    }

    @Override
    public Contract saveAndFlush(Contract contract) {
        return contractRepository.saveAndFlush(contract);
    }

    @Override
    public Contract save(Contract contract) {
        Contract currentContract = contractRepository.save(contract);
        return currentContract;
    }

    @Override
    public void deleteById(int id) {
        contractRepository.deleteById(id);
    }
}
