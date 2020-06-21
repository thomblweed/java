package com.thomblweed.userservice.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userService;
    
    @GetMapping(path = "/users/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }
}