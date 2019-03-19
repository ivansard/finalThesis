package com.ivans.webshop.services;

import com.ivans.webshop.repository.entity.PaymentEntity;
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

    @Override
    public UserEntity getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(UserEntity user, Integer userId) throws Exception {
        UserEntity userInDb = userRepository.findById(userId).orElse(null);
        if (userInDb.equals(null)) {
            throw new Exception("User with submitted ID does not exist");
        }
        user.setId(userInDb.getId());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId) throws Exception {
        UserEntity userInDb = userRepository.findById(userId).orElse(null);
        if (userInDb.equals(null)) {
            throw new Exception("Payment with submitted ID does not exist");
        }
        userRepository.deleteById(userId);
        return ;
    }


}
