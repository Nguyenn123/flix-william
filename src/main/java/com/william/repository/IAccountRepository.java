package com.william.repository;

import com.william.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IAccountRepository extends CrudRepository<AccountEntity, Integer> {
    boolean existsAccountEntitiesByUsernameAndPassword(String username,String password);
    Optional<AccountEntity> findAccountEntitiesByUsername(String username);
}
