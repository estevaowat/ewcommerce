package com.ewcode.ewcomerce.application;

import com.ewcode.ewcomerce.domain.Product;

import java.util.Optional;

public interface ProductGateway {

    void insertOrUpdate(Product product);

    Optional<Product> find(String productId);

    void delete(String productId);

    void update(String productId, Product newProduct);
}
