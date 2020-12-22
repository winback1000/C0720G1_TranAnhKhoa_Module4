package com.furama.service;

import com.furama.entity.Account;
import com.furama.entity.AccountRole;

import java.util.List;

public interface IAccountRoleService {
    List<AccountRole> findAll();
    AccountRole selectAccountRoleById(int id);
}
