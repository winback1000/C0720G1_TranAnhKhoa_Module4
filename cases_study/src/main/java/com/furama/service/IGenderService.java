package com.furama.service;

import com.furama.entity.Gender;

import java.util.List;

public interface IGenderService {
    List<Gender> findAll();
    Gender selectGenderById(int id);
}
