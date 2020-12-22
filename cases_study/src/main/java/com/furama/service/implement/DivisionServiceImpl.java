package com.furama.service.implement;

import com.furama.entity.Division;
import com.furama.repository.DivisionRepository;
import com.furama.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division selectDivisionById(int id) {
        return divisionRepository.findById(id).orElse(null);
    }
}
