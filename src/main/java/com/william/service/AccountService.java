package com.william.service;

import com.william.entity.AccountEntity;
import com.william.repository.IAccountRepository;
import com.william.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public AccountEntity save(AccountEntity accountEntity) {
        return accountRepository.save(accountEntity);
    }

    @Override
    public Optional<AccountEntity> findById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public Iterable<AccountEntity> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public boolean remove(int id) {
        boolean isDelete=false;
        try {
            accountRepository.deleteById(id);
            isDelete= true;
        }catch (Exception e){
            System.out.println(e);
        }
        return isDelete;
    }

    @Override
    public boolean existsAccountEntitiesByUsernameAndPassword(String username, String password) {
        if (accountRepository.existsAccountEntitiesByUsernameAndPassword(username, password)){
            return true;
        }
        return false;
    }

    @Override
    public Optional<AccountEntity> findByUsername(String username) {
        return accountRepository.findAccountEntitiesByUsername(username);
    }
}
