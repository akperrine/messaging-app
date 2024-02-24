package com.perrine.message.controllers;

import com.perrine.message.models.Message;
import com.perrine.message.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{chatId}")
    public ResponseEntity<Map<String, Object>> getMessageByChatId(@PathVariable String chatId, @RequestParam int page) {
        Map<String, Object> result = messageService.getMessagesByChatId(chatId, page);

        return ResponseEntity.ok().body(result);
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