package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.ProductGateway;
import com.ewcode.ewcomerce.domain.Product;

import java.util.Optional;

public class UpdateProductUseCase {

    private final ProductGateway productGateway;

    public UpdateProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public void execute(String productId, Product newProduct) {
        Optional<Product> product = productGateway.find(productId);

        if(product.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }

        productGateway.insertOrUpdate(newProduct);
    }
}
