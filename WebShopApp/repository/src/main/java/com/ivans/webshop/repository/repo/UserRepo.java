package com.ivans.webshop.repository.repo;

import com.ivans.webshop.repository.entity.CompanyUserEntity;
import com.ivans.webshop.repository.entity.UserEntity;
import com.ivans.webshop.repository.entity.WebUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
}
