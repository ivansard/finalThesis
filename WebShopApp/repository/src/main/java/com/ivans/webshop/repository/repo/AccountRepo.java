package com.ivans.webshop.repository.repo;

import com.ivans.webshop.repository.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Integer> {


    AccountEntity findByUserUsername(String username);



}
