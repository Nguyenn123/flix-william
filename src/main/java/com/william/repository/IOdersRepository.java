package com.william.repository;

import com.william.entity.OrdersEntity;
import org.springframework.data.repository.CrudRepository;

public interface IOdersRepository extends CrudRepository<OrdersEntity,Integer> {
}
