package com.codegym.service;

import com.codegym.entity.User;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<User> findAll(Pageable pageable) throws Exception {
        if (true) throw new Exception("a dummy exception");
        return iUserRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
