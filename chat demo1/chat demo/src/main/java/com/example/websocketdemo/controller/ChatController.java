package com.example.websocketdemo.controller;

import com.example.websocketdemo.entity.ChatMessageEntity;
import com.example.websocketdemo.service.ChatMessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final ChatMessageService chatMessageService;

    public ChatController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageEntity sendMessage(ChatMessageEntity chatMessage) {
        return chatMessageService.saveMessage(chatMessage);
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessageEntity addUser(ChatMessageEntity chatMessage) {
        chatMessage.setType(ChatMessageEntity.MessageType.JOIN);
        return chatMessageService.saveMessage(chatMessage);
    }
}
