package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.repository.entity.UserEntity;

import java.util.List;

public interface IUserService {

    List<UserEntity> getAllUsers();

//    List<UserEntity> getAllCompanyUsers();
//
//    List<UserEntity> getAllWebUsers();

    UserEntity getUserById(Integer id);

    UserEntity addUser(UserEntity user);

    UserEntity updateUser(UserEntity user, Integer id) throws Exception;

    void deleteUser(Integer id) throws Exception;


}
