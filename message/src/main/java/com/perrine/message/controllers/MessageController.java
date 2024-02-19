package com.perrine.message.controllers;

import com.perrine.message.models.Message;
import com.perrine.message.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable String id) {
        return messageService.getMessageById(id).orElse(null);
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }

    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable String id, @RequestBody Message updatedMessage) {
        return messageService.updateMessage(id, updatedMessage);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable String id) {
        messageService.deleteMessage(id);
    }
}