package com.furama.service;

import com.furama.entity.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role selectRoleById(int id);
}
