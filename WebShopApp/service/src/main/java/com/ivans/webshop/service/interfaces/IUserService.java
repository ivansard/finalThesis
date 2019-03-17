package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.repository.entity.UserEntity;

import java.util.List;

public interface IUserService {

    List<UserEntity> getAllUsers();

//    List<UserEntity> getAllCompanyUsers();
//
//    List<UserEntity> getAllWebUsers();

    UserEntity getUserById(Integer id);

    void addUser(UserEntity user);

    void updateUser(UserEntity user, Integer id);

    void deleteUser(Integer id);


}
