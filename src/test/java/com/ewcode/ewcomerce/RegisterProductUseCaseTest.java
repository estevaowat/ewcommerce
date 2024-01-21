package com.ewcode.ewcomerce;

import com.ewcode.ewcomerce.application.ProductGateway;
import com.ewcode.ewcomerce.application.usecase.RegisterProductUseCase;
import com.ewcode.ewcomerce.domain.Product;
import com.ewcode.ewcomerce.infra.controller.RegisterProductDTO;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;


@ExtendWith(InstancioExtension.class)
public class RegisterProductUseCaseTest {

    RegisterProductUseCase registerProductUseCase;
    ProductGateway productGateway;

    @BeforeEach
    void setup() {
        productGateway = Mockito.mock(ProductGateway.class);
        registerProductUseCase = new RegisterProductUseCase(productGateway);
    }

    @Test
    @DisplayName("Should register a product with its owner")
    void registerProduct() {
        RegisterProductDTO product = Instancio.create(RegisterProductDTO.class);
        registerProductUseCase.execute(product);
        Mockito.verify(productGateway, Mockito.times(1)).insertOrUpdate(Mockito.any(Product.class));
    }
}
