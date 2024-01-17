package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.CategoryGateway;
import com.ewcode.ewcomerce.domain.Category;

public class RegisterCategoryUseCase {
    private final CategoryGateway categoryGateway;

    public RegisterCategoryUseCase(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public void execute(Category category){
        categoryGateway.insertOrUpdate(category);
    }

}
