package com.ivans.webshop.controllers;

import com.ivans.webshop.repository.entity.AccountEntity;
import com.ivans.webshop.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    public List<AccountEntity> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping(value = "/accounts/{accountId}")
    public AccountEntity getAccountById(@PathVariable Integer accountId) throws Exception {
        try{
            return accountService.getAccountById(accountId);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with submitted ID does not exist", ex);
        }
    }

    @GetMapping(value = "/accounts/user{username}")
    public AccountEntity getAccountByUsername(@PathVariable String username) throws Exception {
        try{
            return accountService.getAccountByUsername(username);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account for submitted username does not exist", ex);
        }
    }

    @PutMapping(value = "/accounts/{accountId}")
    public AccountEntity updateAccount(@RequestBody AccountEntity account,@PathVariable Integer accountId) throws Exception {
        try{
            return accountService.updateAccount(account, accountId);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with submitted ID does not exist", ex);
        }
    }

    @PutMapping(value = "/accounts/user/{username}")
    public AccountEntity updateAccount(@RequestBody AccountEntity account,@PathVariable String username) throws Exception {
        try{
            return accountService.updateAccount(account, username);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account for submitted username does not exist", ex);
        }
    }

    @DeleteMapping(value = "/accounts/user/{username}")
    public void deleteAccount(@PathVariable String username) throws Exception {
        try{
            accountService.deleteAccount(username);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account for submitted username does not exist", ex);
        }
    }

    @DeleteMapping(value = "/accounts/{accountId}")
    public void deleteAccount(@PathVariable Integer accountId) throws Exception {
        try{
            accountService.deleteAccount(accountId);
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with submitted ID does not exist", ex);
        }
    }
}
