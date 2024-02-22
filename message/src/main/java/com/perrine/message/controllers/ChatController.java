package com.perrine.message.controllers;

import com.perrine.message.dto.ChatUsersDTO;
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

    @PostMapping("/create/{userId}")
    public Chat createChat(@PathVariable String userId, @RequestBody Chat chatData) throws Exception {
        return chatService.createChat(userId, chatData);
    }

    @PutMapping("addUsers/{chatId}")
    public Chat addChatUser(@PathVariable String chatId, @RequestBody ChatUsersDTO userIds) throws Exception {
        System.out.println(chatId + userIds.getUserIdsToAdd().get(0));
        return chatService.addChatUser(chatId, userIds);
    }

    @DeleteMapping("/{id}")
    public void deleteChat(@PathVariable String id) {
        chatService.deleteChat(id);
    }
}
