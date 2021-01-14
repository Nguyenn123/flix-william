package com.william.service;

import com.william.entity.OrdersEntity;

import java.util.Optional;

public interface IOrdersService {
    Iterable<OrdersEntity> findAll();
    Optional<OrdersEntity> findById(int id);
    void save(OrdersEntity ordersEntity);
    void deleteById(int id);
}
