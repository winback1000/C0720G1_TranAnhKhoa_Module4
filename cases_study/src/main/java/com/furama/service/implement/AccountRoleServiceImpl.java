package com.furama.service.implement;

import com.furama.entity.AccountRole;
import com.furama.repository.AccountRoleRepository;
import com.furama.service.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountRoleServiceImpl implements IAccountRoleService {

    @Autowired
    private AccountRoleRepository accountRoleRepository;
    @Override
    public List<AccountRole> findAll() {
        return accountRoleRepository.findAll();
    }

    @Override
    public AccountRole selectAccountRoleById(int id) {
        return accountRoleRepository.getOne(id);
    }
}
