package org.pictura.sample_chat_application.controller;

import org.pictura.sample_chat_application.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class RealTimeChat {

    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/message")
    @SendTo("/group/public")
    public Message receiveMessage(@Payload Message message) {
        messagingTemplate.convertAndSend("/group/" + message.getChatId(), message);
        return message;
    }
}
