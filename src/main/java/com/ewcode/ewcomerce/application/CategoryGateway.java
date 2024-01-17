package com.ewcode.ewcomerce.application;

import com.ewcode.ewcomerce.domain.Category;

import java.util.Optional;

public interface CategoryGateway {

    void insertOrUpdate(Category category);

    Optional<Category> find(String categoryId);

    void delete(String categoryId);
}
