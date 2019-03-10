package com.ivans.webshop.services;

import com.ivans.webshop.repository.entity.User;
import com.ivans.webshop.repository.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
