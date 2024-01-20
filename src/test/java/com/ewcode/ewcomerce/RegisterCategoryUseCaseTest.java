package com.ewcode.ewcomerce;

import com.ewcode.ewcomerce.application.CategoryGateway;
import com.ewcode.ewcomerce.application.message.MessageSender;
import com.ewcode.ewcomerce.application.usecase.RegisterCategoryUseCase;
import com.ewcode.ewcomerce.domain.Category;
import com.ewcode.ewcomerce.infra.config.Events;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RegisterCategoryUseCaseTest {

    private RegisterCategoryUseCase registerCategoryUseCase;
    private CategoryGateway categoryGateway;
    private MessageSender messageSender;

    @BeforeEach
    void setup() {
        categoryGateway = Mockito.spy(CategoryGateway.class);
        messageSender = Mockito.spy(MessageSender.class);
        registerCategoryUseCase = new RegisterCategoryUseCase(categoryGateway, messageSender);
    }

    @Test
    @DisplayName("Should create a category with its owner")
    void createCategory() {
        Category category = Instancio.create(Category.class);
        registerCategoryUseCase.execute(category);
        Mockito.verify(categoryGateway, Mockito.times(1)).insertOrUpdate(Mockito.eq(category));
        Mockito.verify(messageSender, Mockito.times(1)).sendMessage(Mockito.eq(Events.CATALOG_EMIT.name()), Mockito.eq(category.owner()));
    }

    @Test
    void deleteCategory() {

    }

// - As a user, I want to update the data of a product or category.
// - As a user, I want to delete a product or category from my catalog.
// - A product can only be associated with one category at a time.
    //           - Assume that products and categories belong only to one owner.


}
