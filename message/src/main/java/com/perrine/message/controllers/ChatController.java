package com.perrine.message.controllers;

import com.perrine.message.models.Chat;
import com.perrine.message.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }

    @GetMapping("/{id}")
    public Chat getChatById(@PathVariable String id) {
        return chatService.getChatById(id).orElse(null);
    }

    @PostMapping
    public Chat createChat(@RequestBody Chat chat) {
        return chatService.createChat(chat);
    }

    @PutMapping("/{id}")
    public Chat updateChat(@PathVariable String id, @RequestBody Chat updatedChat) {
        return chatService.updateChat(id, updatedChat);
    }

    @DeleteMapping("/{id}")
    public void deleteChat(@PathVariable String id) {
        chatService.deleteChat(id);
    }
}
