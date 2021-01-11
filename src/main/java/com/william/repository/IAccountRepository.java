package com.william.repository;

import com.william.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepository extends CrudRepository<AccountEntity, Integer> {
}
