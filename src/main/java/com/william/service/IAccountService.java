package com.william.service;

import com.william.entity.AccountEntity;

import java.util.Optional;

public interface IAccountService {
    AccountEntity save(AccountEntity accountEntity);
    Optional findById(int id);
    Iterable<AccountEntity> findAll();
    boolean remove(int id);
}
