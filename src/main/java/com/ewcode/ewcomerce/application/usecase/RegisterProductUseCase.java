package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.ProductGateway;
import com.ewcode.ewcomerce.domain.Product;
import com.ewcode.ewcomerce.infra.controller.RegisterProductDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RegisterProductUseCase {

    private static final Logger logger = LogManager.getLogger(RegisterProductUseCase.class);
    private final ProductGateway productGateway;

    public RegisterProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public void execute(RegisterProductDTO dto) {
        Product product = new Product(dto.title(), dto.description(), dto.price(), null, dto.owner());

        if(product.category() == null) {
            logger.info("Saving product without category");
        }

        logger.info("Saving product with category");
        productGateway.insertOrUpdate(product);
    }
}