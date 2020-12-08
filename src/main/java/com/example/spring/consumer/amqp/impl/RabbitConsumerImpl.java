package com.example.spring.consumer.amqp.impl;

import com.example.spring.consumer.amqp.AmqpConsumer;
import com.example.spring.consumer.dto.MessageDTO;
import com.example.spring.consumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumerImpl implements AmqpConsumer<MessageDTO> {

    @Autowired
    private ConsumerService consumerService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(MessageDTO messageDTO) {
        try{
            consumerService.action(messageDTO);
        }catch (Exception e){
            throw new AmqpRejectAndDontRequeueException(e);
        }

    }
}
