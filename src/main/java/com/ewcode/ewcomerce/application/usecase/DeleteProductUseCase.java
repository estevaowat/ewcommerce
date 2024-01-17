package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.ProductGateway;

public class DeleteProductUseCase {

    private final ProductGateway productGateway;

    public DeleteProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public void execute(String productId) {
        productGateway.delete(productId);
    }

}