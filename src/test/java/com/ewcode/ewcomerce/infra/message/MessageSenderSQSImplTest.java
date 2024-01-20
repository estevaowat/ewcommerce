package com.ewcode.ewcomerce.infra.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageSenderSQSImplTest {

    @Test
    @DisplayName("When queue name is null should throw IllegalArgumentException")
    void queueNameNull() {
        MessageSenderSQSImpl sender = new MessageSenderSQSImpl(null);
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> sender.sendMessage(null, null));
        assertEquals("Queue name cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("When queue name is empty should throw IllegalArgumentException")
    void queueNameEmpty() {
        MessageSenderSQSImpl sender = new MessageSenderSQSImpl(null);
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> sender.sendMessage("", null));
        assertEquals("Queue name cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("When message is null should throw IllegalArgumentException")
    void messageNull() {
        MessageSenderSQSImpl sender = new MessageSenderSQSImpl(null);
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> sender.sendMessage("queue", null));
        assertEquals("Message cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should send message sucessfully")
    void sendMessage() {
        SqsClient sqsClientMocked = Mockito.mock(SqsClient.class);
        MessageSenderSQSImpl sender = new MessageSenderSQSImpl(sqsClientMocked);
        GetQueueUrlResponse getQueueUrlResponse = GetQueueUrlResponse.builder().queueUrl("queueUrl").build();
        Mockito.when(sqsClientMocked.getQueueUrl(Mockito.any(GetQueueUrlRequest.class))).thenReturn(getQueueUrlResponse);
        sender.sendMessage("queue", "a simple message");
        Mockito.verify(sqsClientMocked, Mockito.times(1)).sendMessage(Mockito.any(SendMessageRequest.class));
    }
}