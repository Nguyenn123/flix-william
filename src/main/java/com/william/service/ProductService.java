package com.william.service;

import com.william.entity.ProductEntity;
import com.william.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
