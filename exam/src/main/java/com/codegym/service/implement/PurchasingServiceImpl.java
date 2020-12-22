package com.codegym.service.implement;


import com.codegym.entity.Purchasing;
import com.codegym.repository.PurchasingRepository;
import com.codegym.service.IPurchasingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasingServiceImpl implements IPurchasingService {

    @Autowired
    private PurchasingRepository purchasingRepository;


    @Override
    public List<Purchasing> findAll() {
        return purchasingRepository.findAll();
    }

    @Override
    public Purchasing selectPurchasingById(int id) {
        return purchasingRepository.getOne(id);
    }

    @Override
    public void save(Purchasing purchasing) {
        purchasingRepository.save(purchasing);
    }

    @Override
    public List<Purchasing> search(String serviceType, String keyword) {
        return purchasingRepository.findAllByServiceTypeContainingAndCustomer_NameContaining(serviceType,keyword);
    }

    @Override
    public void deleteById(int deleteId) {
        purchasingRepository.deleteById(deleteId);
    }
}
