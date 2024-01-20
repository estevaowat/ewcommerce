package com.ewcode.ewcomerce;

import com.ewcode.ewcomerce.application.CategoryGateway;
import com.ewcode.ewcomerce.application.usecase.DeleteCategoryUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DeleteCategoryUseCaseTest {

    // As a user, I want to delete a product or category from my catalog.
    DeleteCategoryUseCase deleteCategoryUseCase;
    CategoryGateway categoryGateway;
    

    @BeforeEach
    void setup() {
        categoryGateway = Mockito.mock(CategoryGateway.class);
        deleteCategoryUseCase = new DeleteCategoryUseCase(categoryGateway);
    }

    @Test
    @DisplayName("Should delete category")
    void deleteCategory() {
        String categoryId = "1";
        deleteCategoryUseCase.execute(categoryId);
        Mockito.verify(categoryGateway, Mockito.times(1)).delete(Mockito.anyString());
    }
}
