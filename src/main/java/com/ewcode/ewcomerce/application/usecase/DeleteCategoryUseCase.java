package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.CategoryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryUseCase {

    private final CategoryGateway categoryGateway;

    @Autowired
    public DeleteCategoryUseCase(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    public void execute(String categoryId) {
        categoryGateway.delete(categoryId);
    }
}
