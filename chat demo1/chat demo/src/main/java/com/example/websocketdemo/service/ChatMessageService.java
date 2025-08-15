package com.example.websocketdemo.service;

import com.example.websocketdemo.entity.ChatMessageEntity;
import com.example.websocketdemo.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessageEntity saveMessage(ChatMessageEntity message) {
        return chatMessageRepository.save(message);
    }

    public List<ChatMessageEntity> getAllMessages() {
        return chatMessageRepository.findAll();
    }
}
