package com.example.spring.consumer.service;

import com.example.spring.consumer.dto.MessageDTO;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    public void action(MessageDTO messageDTO){
        System.out.println("Mensagem consumida: "+messageDTO.getText());
    }
}
