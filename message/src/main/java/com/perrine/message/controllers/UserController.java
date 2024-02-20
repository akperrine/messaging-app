package com.perrine.message.controllers;

import com.perrine.message.dto.UserDTO;
import com.perrine.message.models.User;
import com.perrine.message.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id).orElse(null);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User user) throws Exception {
        UserDTO newUser = userService.createUser(user);
        System.out.println(newUser);
        return newUser;
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody User user) throws Exception {return userService.login(user);}

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
