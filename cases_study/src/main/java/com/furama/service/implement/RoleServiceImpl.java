package com.furama.service.implement;

import com.furama.entity.Role;
import com.furama.repository.RoleRepository;
import com.furama.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role selectRoleById(int id) {
        return roleRepository.findById(id).orElse(null);
    }
}
