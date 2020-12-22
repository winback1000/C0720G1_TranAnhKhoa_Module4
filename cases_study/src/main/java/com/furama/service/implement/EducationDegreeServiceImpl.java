package com.furama.service.implement;

import com.furama.entity.EducationDegree;
import com.furama.repository.EducationDegreeRepository;
import com.furama.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree selectEducationDegreeById(int id) {
        return educationDegreeRepository.findById(id).orElse(null);
    }
}
