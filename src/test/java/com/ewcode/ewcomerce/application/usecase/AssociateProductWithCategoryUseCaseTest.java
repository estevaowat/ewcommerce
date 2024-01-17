package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.CategoryGateway;
import com.ewcode.ewcomerce.application.ProductGateway;
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

    @BeforeEach
    void setup() {
        productGateway = Mockito.mock(ProductGateway.class);
        CategoryGateway categoryGateway = Mockito.mock(CategoryGateway.class);
        associateProductWithCategoryUseCase = new AssociateProductWithCategoryUseCase(productGateway, categoryGateway);
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


}