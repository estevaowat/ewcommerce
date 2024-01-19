package com.ewcode.ewcomerce.infra.gateway;

import com.ewcode.ewcomerce.application.ProductGateway;
import com.ewcode.ewcomerce.domain.Product;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoProductGatewayImpl implements ProductGateway {

    @Override
    public void insertOrUpdate(Product product) {

    }

    @Override
    public Optional<Product> find(String productId) {
        return Optional.empty();
    }

    @Override
    public void delete(String productId) {

    }

    @Override
    public void update(String productId, Product newProduct) {

    }
}
