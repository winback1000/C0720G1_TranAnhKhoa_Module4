package com.furama.service;

import com.furama.entity.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();
    ServiceType selectServiceTypeById(int id);
}
