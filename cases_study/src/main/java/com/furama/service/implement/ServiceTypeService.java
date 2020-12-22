package com.furama.service.implement;

import com.furama.entity.ServiceType;
import com.furama.repository.ServiceTypeRepository;
import com.furama.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType selectServiceTypeById(int id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }
}
