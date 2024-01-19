package com.ewcode.ewcomerce.infra.gateway;

import com.ewcode.ewcomerce.application.CategoryGateway;
import com.ewcode.ewcomerce.domain.Category;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoCategoryGatewayImpl implements CategoryGateway {

    @Override
    public void insertOrUpdate(Category category) {

    }

    @Override
    public Optional<Category> find(String categoryId) {
        return Optional.empty();
    }

    @Override
    public void delete(String categoryId) {

    }
}
