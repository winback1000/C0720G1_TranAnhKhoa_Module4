package com.furama.service.implement;

import com.furama.entity.Account;
import com.furama.repository.AccountRepository;
import com.furama.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account selectAccountById(int id) {
        return accountRepository.getOne(id);
    }
}
