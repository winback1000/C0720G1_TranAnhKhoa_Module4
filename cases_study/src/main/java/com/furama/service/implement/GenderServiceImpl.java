package com.furama.service.implement;

import com.furama.entity.Gender;
import com.furama.repository.GenderRepository;
import com.furama.service.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements IGenderService {
    @Autowired
    private GenderRepository genderRepository;
    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public Gender selectGenderById(int id) {
        return genderRepository.findById(id).orElse(null);
    }
}
