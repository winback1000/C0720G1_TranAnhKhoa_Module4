package com.furama.service.implement;

import com.furama.entity.RentType;
import com.furama.repository.RentTypeRepository;
import com.furama.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType selectRentTypeById(int id) {
        return rentTypeRepository.findById(id).orElse(null);
    }
}
