package com.furama.service;

import com.furama.entity.Division;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();
    Division selectDivisionById(int id);
}
