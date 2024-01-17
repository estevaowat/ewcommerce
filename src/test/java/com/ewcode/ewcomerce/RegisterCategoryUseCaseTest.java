package com.ewcode.ewcomerce;

import com.ewcode.ewcomerce.application.CategoryGateway;
import com.ewcode.ewcomerce.application.usecase.RegisterCategoryUseCase;
import com.ewcode.ewcomerce.domain.Category;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RegisterCategoryUseCaseTest {

    RegisterCategoryUseCase registerCategoryUseCase;
    CategoryGateway categoryGateway;
    // As a user, I want to register a category with its owner, so that I can access its data in the future (title, description, owner ID).


    @BeforeEach
    void setup() {
        categoryGateway = Mockito.spy(CategoryGateway.class);
        registerCategoryUseCase = new RegisterCategoryUseCase(categoryGateway);
    }

    @Test
    @DisplayName("Should create a category with its owner")
    void createCategory() {
        Category category = Instancio.create(Category.class);
        registerCategoryUseCase.execute(category);
        Mockito.verify(categoryGateway, Mockito.times(1)).insertOrUpdate(category);
    }

    @Test
    void deleteCategory() {

    }

// - As a user, I want to update the data of a product or category.
// - As a user, I want to delete a product or category from my catalog.
// - A product can only be associated with one category at a time.
    //           - Assume that products and categories belong only to one owner.


}
