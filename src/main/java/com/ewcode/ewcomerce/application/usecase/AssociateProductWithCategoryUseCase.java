package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.CategoryGateway;
import com.ewcode.ewcomerce.application.ProductGateway;
import com.ewcode.ewcomerce.domain.Category;
import com.ewcode.ewcomerce.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AssociateProductWithCategoryUseCase {

    private final ProductGateway productGateway;
    private final CategoryGateway categoryGateway;

    @Autowired
    public AssociateProductWithCategoryUseCase(ProductGateway productGateway, CategoryGateway categoryGateway) {
        this.productGateway = productGateway;
        this.categoryGateway = categoryGateway;
    }

    public void execute(String productId, String categoryId) {
        Optional<Product> product = productGateway.find(productId);

        if(product.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }

        Optional<Category> category = categoryGateway.find(categoryId);

        if(category.isEmpty()) {
            throw new IllegalArgumentException("Category not found");
        }

        Product productWithNewCategory = product.get();
        productWithNewCategory.category(category.get());
        productGateway.insertOrUpdate(productWithNewCategory);
    }
}
