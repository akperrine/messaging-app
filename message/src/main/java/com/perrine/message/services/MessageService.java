package com.perrine.message.services;

import com.perrine.message.models.Message;
import com.perrine.message.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.support.WindowIterator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    private static final int DEFAULT_PAGE_SIZE = 4;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessageById(String id) {
        return messageRepository.findById(id);
    }

    public Map<String, Object> getMessagesByChatId(String chatId, int page) {
        Pageable pageable = PageRequest.of(page, DEFAULT_PAGE_SIZE, Sort.by(Sort.Direction.DESC, "timestamp"));
        Page<Message> messages = messageRepository.findByChatIdInOrderByTimestampDesc(chatId, pageable);
        System.out.println(messages.toString());
        Map<String, Object> result = new HashMap<>();
        result.put("content", messages.getContent());
        result.put("totalItems", messages.getTotalElements());
        result.put("totalPages", messages.getTotalPages());
        result.put("currentPage", messages.getNumber());

        return result;
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
