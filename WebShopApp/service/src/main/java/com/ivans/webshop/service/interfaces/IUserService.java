package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.dto.UserDTO;
import com.ivans.webshop.repository.entity.UserEntity;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Integer id) throws Exception;

    UserEntity addUser(UserEntity user);

    UserEntity updateUser(UserEntity user, Integer id) throws Exception;

    void deleteUser(Integer id) throws Exception;


}
