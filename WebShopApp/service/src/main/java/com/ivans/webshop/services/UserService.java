package com.ivans.webshop.services;

import com.ivans.webshop.repository.entity.UserEntity;
import com.ivans.webshop.repository.repo.UserRepo;
import com.ivans.webshop.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

//    @Override
//    public List<UserEntity> getAllCompanyUsers() {
//        return userRepository.findByType(2);
//    }
//
//    @Override
//    public List<UserEntity> getAllWebUsers() {
//        return userRepository.findByType(1);
//    }

    @Override
    public UserEntity getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void addUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserEntity user, Integer id) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }


}
