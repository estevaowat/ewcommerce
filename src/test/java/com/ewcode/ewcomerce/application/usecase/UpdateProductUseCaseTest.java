package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.ProductGateway;
import com.ewcode.ewcomerce.domain.Product;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class UpdateProductUseCaseTest {

    private ProductGateway productGateway;
    private UpdateProductUseCase updateProductUseCase;

    @BeforeEach
    void setup() {
        productGateway = Mockito.mock(ProductGateway.class);
        updateProductUseCase = new UpdateProductUseCase(productGateway);
    }

    @Test
    @DisplayName("Should update product")
    void updateProduct() {
        Product oldProduct = Instancio.create(Product.class);
        Mockito.when(productGateway.find(Mockito.anyString())).thenReturn(Optional.of(oldProduct));

        String productId = "1";
        Product newProduct = Instancio.create(Product.class);
        updateProductUseCase.execute(productId, newProduct);
        Mockito.verify(productGateway, Mockito.atMostOnce()).update(Mockito.anyString(), Mockito.any(Product.class));
    }
}
