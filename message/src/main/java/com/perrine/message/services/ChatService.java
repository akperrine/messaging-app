package com.perrine.message.services;

import com.perrine.message.models.Chat;
import com.perrine.message.models.User;
import com.perrine.message.repositories.ChatRepository;
import com.perrine.message.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    UserService userService;

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public Optional<Chat> getChatById(String id) {
        return chatRepository.findById(id);
    }

    public Chat createChat(String userId) throws Exception {
        Optional<User> userCreatingChat = userService.getUserById(userId);
        if (userCreatingChat.isEmpty()) {
            throw new Exception("User does not exist");
        }
        Chat newChat = new Chat();
        List<User> users = new ArrayList<>();
        users.add(userCreatingChat.get());
        newChat.setUsers(users);
        return chatRepository.save(newChat);
    }

    public Chat updateChat(String id, Chat updatedChat) {
        updatedChat.setId(id);
        return chatRepository.save(updatedChat);
    }

    public void deleteChat(String id) {
        chatRepository.deleteById(id);
    }
}
