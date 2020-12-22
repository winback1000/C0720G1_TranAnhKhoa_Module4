package com.furama.service;

import com.furama.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    List<Service> findAll();
    Service selectServiceById(int id);

    Page<Service> findAllWithPage(Pageable pageable);

    Page<Service> searchService(String searchData, Pageable pageable);

    void save(Service service);

    void delete(int deleteID);
}
