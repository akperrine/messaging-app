package com.perrine.message.services;

import com.perrine.message.dto.UserDTO;
import com.perrine.message.mappers.UserMapper;
import com.perrine.message.models.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.perrine.message.repositories.UserRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            return null;
        } else {
            return userRepository.save(user);
        }
    }

    public User updateUser(String id, User updatedUser) {
        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public UserDTO login(User user) throws Exception {
        System.out.println(user.toString());
//        ObjectId userId = new ObjectId(user.getId());

        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        System.out.println(foundUser.get().getPassword() + " " + user.getPassword());
        if (foundUser.isEmpty()) {
            throw new Exception("User not found");
        } else if (!foundUser.get().getPassword().equals(user.getPassword())) {
            throw new Exception("Wrong Password");
        } else {
            UserDTO userDTO = UserMapper.mapUserToDTO(foundUser.get());
            return userDTO;
        }
    }
}