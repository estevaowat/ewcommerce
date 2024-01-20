package com.ewcode.ewcomerce.application.usecase;

import com.ewcode.ewcomerce.application.CategoryGateway;
import com.ewcode.ewcomerce.application.message.MessageSender;
import com.ewcode.ewcomerce.domain.Category;
import com.ewcode.ewcomerce.infra.config.Events;

public class RegisterCategoryUseCase {

    private final CategoryGateway categoryGateway;
    private final MessageSender messageSender;

    public RegisterCategoryUseCase(CategoryGateway categoryGateway, MessageSender messageSender) {
        this.categoryGateway = categoryGateway;
        this.messageSender = messageSender;
    }

    public void execute(Category category) {
        categoryGateway.insertOrUpdate(category);
        messageSender.sendMessage(Events.CATALOG_EMIT.name(), category.owner());

    }

}
