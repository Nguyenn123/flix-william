package com.william.service;

import com.william.entity.OrdersEntity;
import com.william.repository.IOdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrdersService implements IOrdersService{
    @Autowired
    private IOdersRepository odersRepository;
    @Override
    public Iterable<OrdersEntity> findAll() {
        return odersRepository.findAll();
    }

    @Override
    public Optional<OrdersEntity> findById(int id) {
        return odersRepository.findById(id);
    }

    @Override
    public void save(OrdersEntity ordersEntity) {
        odersRepository.save(ordersEntity);
    }

    @Override
    public void deleteById(int id) {
        odersRepository.deleteById(id);
    }
}
