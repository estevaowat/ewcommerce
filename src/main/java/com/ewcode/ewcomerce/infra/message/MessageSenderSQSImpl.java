package com.ewcode.ewcomerce.infra.message;


import com.ewcode.ewcomerce.application.message.MessageSender;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.util.Objects;

@Component
public class MessageSenderSQSImpl implements MessageSender {

    private final SqsClient sqsClient;

    public MessageSenderSQSImpl(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    @Override
    public void sendMessage(String queueName, String message) {
        if(Objects.isNull(queueName) || queueName.isBlank()) {
            throw new IllegalArgumentException("Queue name cannot be null or empty");
        }

        if(Objects.isNull(message)) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }

        GetQueueUrlRequest getQueueRequest = GetQueueUrlRequest.builder().queueName(queueName).build();
        GetQueueUrlResponse queue = sqsClient.getQueueUrl(getQueueRequest);
        String queueUrl = queue.queueUrl();

        SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .delaySeconds(5)
                .build();

        sqsClient.sendMessage(sendMsgRequest);
    }
}
