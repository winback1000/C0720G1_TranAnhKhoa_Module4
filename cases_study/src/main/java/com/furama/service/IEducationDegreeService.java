package com.furama.service;

import com.furama.entity.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();
    EducationDegree selectEducationDegreeById(int id);
}
