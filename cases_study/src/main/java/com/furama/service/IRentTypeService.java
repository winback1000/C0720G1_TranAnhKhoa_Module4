package com.furama.service;

import com.furama.entity.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
    RentType selectRentTypeById(int id);
}
