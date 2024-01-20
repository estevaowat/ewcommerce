package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.CategoryGateway;
import com.ewcode.ewcomerce.application.ProductGateway;
import com.ewcode.ewcomerce.application.message.MessageSender;
import com.ewcode.ewcomerce.domain.Category;
import com.ewcode.ewcomerce.domain.Product;
import com.ewcode.ewcomerce.infra.config.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AssociateProductWithCategoryUseCase {

    private final ProductGateway productGateway;
    private final CategoryGateway categoryGateway;
    private final MessageSender messageSender;

    @Autowired
    public AssociateProductWithCategoryUseCase(ProductGateway productGateway, CategoryGateway categoryGateway, MessageSender messageSender) {
        this.productGateway = productGateway;
        this.categoryGateway = categoryGateway;
        this.messageSender = messageSender;
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
        productWithNewCategory.setCategory(category.get());
        productGateway.insertOrUpdate(productWithNewCategory);
        messageSender.sendMessage(Events.CATALOG_EMIT.name(), productWithNewCategory.owner());

    }
}
