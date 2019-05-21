package com.ivans.webshop.services;

import com.ivans.webshop.dto.UserDTO;
import com.ivans.webshop.mappers.UserMapper;
import com.ivans.webshop.repository.entity.AccountEntity;
import com.ivans.webshop.repository.entity.PaymentEntity;
import com.ivans.webshop.repository.entity.UserEntity;
import com.ivans.webshop.repository.repo.UserRepo;
import com.ivans.webshop.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepository;
    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for (UserEntity userEntity: userEntities) {
            userDTOs.add(userMapper.user2DTO(userEntity));
        }
        return userDTOs;
    }

    @Override
    public UserDTO getUserById(Integer userId) throws Exception{
        UserEntity user = userRepository.findById(userId).orElse(null);
        if(user.equals(null)){
            throw new Exception("Account with submitted ID does not exist");
        }
        return userMapper.user2DTO(user);
    }

    @Override
    public UserDTO getUserByUsername(String username) throws Exception {
        UserEntity user = userRepository.findByUsername(username);
        if(user.equals(null)){
            throw new Exception("User with submitted username does not exist");
        }
        UserDTO userToReturn = userMapper.user2DTO(user);
        return userToReturn;
    }

    @Override
    public UserEntity addUser(UserEntity user) throws Exception {
        if(userRepository.findByUsername(user.getUsername()) != null){
            throw new Exception("User with submitted username already exists");
        }
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
