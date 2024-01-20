package com.ewcode.ewcomerce.application.message;

public interface MessageSender {

    void sendMessage(String queueName, String message);
}
