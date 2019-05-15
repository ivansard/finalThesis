package com.ivans.webshop.controllers;

import com.ivans.webshop.dto.UserDTO;
import com.ivans.webshop.repository.entity.UserEntity;
import com.ivans.webshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public UserDTO getUserById(@PathVariable Integer id) throws Exception {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/users")
    public void addUser(@RequestBody UserEntity user){
        userService.addUser(user);
    }

    @PutMapping(value = "/users/{id}")
    public void updateUser(@RequestBody UserEntity user, @PathVariable Integer id) throws Exception {
         userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable Integer id) throws Exception {
         userService.deleteUser(id);
    }
}
