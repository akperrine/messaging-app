package com.perrine.message.services;

import com.perrine.message.models.Message;
import com.perrine.message.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessageById(String id) {
        return messageRepository.findById(id);
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message updateMessage(String id, Message updatedMessage) {
        updatedMessage.setId(id);
        return messageRepository.save(updatedMessage);
    }

    public void deleteMessage(String id) {
        messageRepository.deleteById(id);
    }
}
