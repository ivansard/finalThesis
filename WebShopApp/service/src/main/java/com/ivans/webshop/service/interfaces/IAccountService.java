package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.dto.AccountDTO;
import com.ivans.webshop.repository.entity.AccountEntity;
import com.ivans.webshop.repository.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAccountService {

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccountById(Integer id) throws Exception;

    AccountDTO getAccountByUsername(String username) throws Exception;

    AccountEntity getAccountByUsername(String username, String dummy) throws Exception;

    AccountEntity updateAccount(AccountEntity user, Integer id) throws Exception;

    AccountEntity updateAccount(AccountEntity user, String username) throws Exception;

    AccountEntity saveAccount(AccountEntity account);

    void deleteAccount(String username) throws Exception;

    void deleteAccount(Integer id) throws Exception;
}
