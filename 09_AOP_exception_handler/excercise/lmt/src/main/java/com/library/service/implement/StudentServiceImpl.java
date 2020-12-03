package com.library.service.implement;


import com.library.model.Student;
import com.library.repository.IStudentRepository;
import com.library.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }
}
