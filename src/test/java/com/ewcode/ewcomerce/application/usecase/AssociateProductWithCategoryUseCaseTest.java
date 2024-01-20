package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.CategoryGateway;
import com.ewcode.ewcomerce.application.ProductGateway;
import com.ewcode.ewcomerce.application.message.MessageSender;
import com.ewcode.ewcomerce.domain.Category;
import com.ewcode.ewcomerce.domain.Product;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import java.util.Optional;

@ExtendWith(InstancioExtension.class)
public class AssociateProductWithCategoryUseCaseTest {

    private AssociateProductWithCategoryUseCase associateProductWithCategoryUseCase;

    private ProductGateway productGateway;
    private CategoryGateway categoryGateway;
    private MessageSender messageSender;

    @BeforeEach
    void setup() {
        productGateway = Mockito.mock(ProductGateway.class);
        categoryGateway = Mockito.mock(CategoryGateway.class);
        messageSender = Mockito.mock(MessageSender.class);
        associateProductWithCategoryUseCase = new AssociateProductWithCategoryUseCase(productGateway, categoryGateway, messageSender);
    }

    @Test
    @DisplayName("When product is null should throw IllegalArgumentException")
    void productNull() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> associateProductWithCategoryUseCase.execute(null, null));
        Assertions.assertEquals("Product not found", exception.getMessage());
    }

    @Test
    @DisplayName("When category is null should throw IllegalArgumentException")
    void categoryNull() {
        Product product = Instancio.create(Product.class);
        Mockito.when(productGateway.find(Mockito.anyString())).thenReturn(Optional.of(product));
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> associateProductWithCategoryUseCase.execute("1", null));
        Assertions.assertEquals("Category not found", exception.getMessage());
    }

    @Test
    @DisplayName("Should associate product with category")
    void associateProductWithCategory() {
        String productId = "1";
        String categoryId = "1";
        Mockito.when(productGateway.find(Mockito.anyString())).thenReturn(Optional.of(Instancio.create(Product.class)));
        Mockito.when(categoryGateway.find(Mockito.anyString())).thenReturn(Optional.of(Instancio.create(Category.class)));
        associateProductWithCategoryUseCase.execute(productId, categoryId);
        Mockito.verify(messageSender, Mockito.times(1)).sendMessage(Mockito.anyString(), Mockito.anyString());

    }


}