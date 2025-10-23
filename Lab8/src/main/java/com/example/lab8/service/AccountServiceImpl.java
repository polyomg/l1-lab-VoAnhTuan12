package com.example.lab8.service;

import com.example.lab8.entity.Account;
import com.example.lab8.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository repo;

    @Override
    public Account findById(String username) {
        return repo.findById(username).orElse(null);
    }

    @Override
    public Account save(Account account) {
        return repo.save(account);
    }
}
