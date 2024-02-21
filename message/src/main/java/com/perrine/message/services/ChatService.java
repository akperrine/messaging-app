package com.perrine.message.services;

import com.perrine.message.dto.ChatUsersDTO;
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

    public Chat createChat(String userId, Chat chatData) throws Exception {
        Optional<User> userCreatingChat = userService.getUserById(userId);
        if (userCreatingChat.isEmpty()) {
            throw new Exception("User does not exist");
        }
        Chat newChat = new Chat();
        List<User> users = new ArrayList<>();
        users.add(userCreatingChat.get());
        newChat.setUsers(users);
        newChat.setChatName(chatData.getChatName());
        return chatRepository.save(newChat);
    }

    public Chat addChatUser(String chatId, ChatUsersDTO listOfUsersDto) throws Exception {
        Optional<Chat> currentChatOptional = chatRepository.findById(chatId);
        if (currentChatOptional.isEmpty()) {
            throw new Exception("Error retrieving Chat");
        }
        Chat currentChat = currentChatOptional.get();
        List<User> currentUsers = currentChat.getUsers();
        System.out.println(currentUsers);

        for (String userId : listOfUsersDto.getUserIdsToAdd()) {

        Optional<User> userToAddOptional = userService.getUserById(userId);
        if (userToAddOptional.isEmpty()) {
            throw new Exception("User does not exist");
        }
        User userToAdd = userToAddOptional.get();
        if (currentUsers.contains(userToAdd)) {
            throw new Exception("User is already in this chat");
        }
        currentUsers.add(userToAdd);

        }

        currentChat.setUsers(currentUsers);
        return chatRepository.save(currentChat);
    }

    public void deleteChat(String id) {
        chatRepository.deleteById(id);
    }
}
