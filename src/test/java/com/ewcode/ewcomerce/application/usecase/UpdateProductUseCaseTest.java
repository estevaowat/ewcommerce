package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.ProductGateway;
import com.ewcode.ewcomerce.application.message.MessageSender;
import com.ewcode.ewcomerce.domain.Product;
import com.ewcode.ewcomerce.infra.config.Events;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class UpdateProductUseCaseTest {

    private ProductGateway productGateway;
    private UpdateProductUseCase updateProductUseCase;
    private MessageSender messageSender;

    @BeforeEach
    void setup() {
        productGateway = Mockito.mock(ProductGateway.class);
        messageSender = Mockito.mock(MessageSender.class);
        updateProductUseCase = new UpdateProductUseCase(productGateway, messageSender);
    }

    @Test
    @DisplayName("Should update product")
    void updateProduct() {
        Product oldProduct = Instancio.create(Product.class);
        Mockito.when(productGateway.find(Mockito.anyString())).thenReturn(Optional.of(oldProduct));
        String productId = "1";
        Product newProduct = Instancio.create(Product.class);
        updateProductUseCase.execute(productId, newProduct);
        Mockito.verify(productGateway, Mockito.times(1)).insertOrUpdate(Mockito.eq(newProduct));
        Mockito.verify(messageSender, Mockito.times(1)).sendMessage(Mockito.eq(Events.CATALOG_EMIT.name()), Mockito.eq(newProduct.owner()));
    }
}
