package com.ivans.webshop.services;

import com.ivans.webshop.dto.AccountDTO;
import com.ivans.webshop.mappers.AccountMapper;
import com.ivans.webshop.repository.entity.AccountEntity;
import com.ivans.webshop.repository.entity.UserEntity;
import com.ivans.webshop.repository.repo.AccountRepo;
import com.ivans.webshop.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private AccountMapper accountMapper;


    @Override
    public List<AccountDTO> getAllAccounts() {
        List<AccountEntity> accountEntities = accountRepo.findAll();
        List<AccountDTO> accountDTOs = new ArrayList<AccountDTO>();
        for (AccountEntity accountEntity: accountEntities) {
            accountDTOs.add(accountMapper.account2DTO(accountEntity));
        }
        return accountDTOs;
    }

    @Override
    public AccountDTO getAccountById(Integer accountId) throws Exception {
        AccountEntity account = accountRepo.findById(accountId).orElse(null);
        if(account.equals(null)){
            throw new Exception("Account with submitted ID does not exist");
        }
        return accountMapper.account2DTO(account);
    }

    @Override
    public AccountDTO getAccountByUsername(String username) throws Exception {
        AccountEntity account = accountRepo.findByUserUsername(username);
        if(account.equals(null)){
            throw new Exception("Account for submitted username does not exist");
        }
        return accountMapper.account2DTO(account);
    }

    @Override
    public AccountEntity updateAccount(AccountEntity account, Integer accountId) throws Exception {
        AccountEntity accountInDb = accountRepo.findById(accountId).orElse(null);
        if (accountInDb.equals(null)) {
            throw new Exception("Account with submitted ID does not exist");
        }
        account.setId(accountInDb.getId());
        return accountRepo.save(account);
    }

    @Override
    public AccountEntity updateAccount(AccountEntity account, String username) throws Exception {
        AccountEntity accountInDb = accountRepo.findByUserUsername(username);
        if (accountInDb.equals(null)) {
            throw new Exception("Account with submitted ID does not exist");
        }
        account.setId(accountInDb.getId());
        return accountRepo.save(account);
    }

    @Override
    public void deleteAccount(String username) throws Exception {
        AccountEntity accountInDb = accountRepo.findByUserUsername(username);
        if (accountInDb.equals(null)) {
            throw new Exception("Account with submitted ID does not exist");
        }
        accountRepo.deleteById(accountInDb.getId());
        return;
    }

    @Override
    public void deleteAccount(Integer accountId) throws Exception {
        AccountEntity accountInDb = accountRepo.findById(accountId).orElse(null);
        if (accountInDb.equals(null)) {
            throw new Exception("Account with submitted ID does not exist");
        }
        accountRepo.deleteById(accountId);
        return;
    }
}
