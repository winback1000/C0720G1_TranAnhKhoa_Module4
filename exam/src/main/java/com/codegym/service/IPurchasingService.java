package com.codegym.service;


import com.codegym.entity.Customer;
import com.codegym.entity.Purchasing;

import java.util.List;

public interface IPurchasingService {
    List<Purchasing> findAll();
    Purchasing selectPurchasingById(int id);

    void save(Purchasing purchasing);

    List<Purchasing> search(String serviceType, String keyword);

    void deleteById(int deleteId);
}
