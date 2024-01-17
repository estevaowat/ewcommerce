package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.ProductGateway;
import com.ewcode.ewcomerce.domain.Product;

public class RegisterProductUseCase {

    private final ProductGateway productGateway;

    public RegisterProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public void execute(Product product) {
        if(product.getCategory() == null) {
            System.out.println("Saving product without category");
        }

        productGateway.insertOrUpdate(product);

    }

}