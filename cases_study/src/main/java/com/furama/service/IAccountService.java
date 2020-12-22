package com.furama.service;

import com.furama.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account selectAccountById(int id);
}
