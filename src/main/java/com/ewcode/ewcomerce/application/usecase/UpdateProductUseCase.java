package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.ProductGateway;
import com.ewcode.ewcomerce.application.message.MessageSender;
import com.ewcode.ewcomerce.domain.Product;
import com.ewcode.ewcomerce.infra.config.Events;

import java.util.Optional;

public class UpdateProductUseCase {

    private final ProductGateway productGateway;
    private final MessageSender messageSender;

    public UpdateProductUseCase(ProductGateway productGateway, MessageSender messageSender) {
        this.productGateway = productGateway;
        this.messageSender = messageSender;
    }

    public void execute(String productId, Product newProduct) {
        Optional<Product> product = productGateway.find(productId);

        if(product.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }

        productGateway.insertOrUpdate(newProduct);
        messageSender.sendMessage(Events.CATALOG_EMIT.name(), newProduct.owner());
    }
}
