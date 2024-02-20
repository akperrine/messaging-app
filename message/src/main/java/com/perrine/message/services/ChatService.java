package com.perrine.message.services;

import com.perrine.message.models.Chat;
import com.perrine.message.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public Optional<Chat> getChatById(String id) {
        return chatRepository.findById(id);
    }

    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }

    public Chat updateChat(String id, Chat updatedChat) {
        updatedChat.setId(id);
        return chatRepository.save(updatedChat);
    }

    public void deleteChat(String id) {
        chatRepository.deleteById(id);
    }
}
