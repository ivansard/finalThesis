package com.ivans.webshop.repository.entity;

import com.ivans.webshop.repository.enums.UserState;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("1")
public class WebUserEntity extends UserEntity {

    @OneToOne(mappedBy = "user")
    private AccountEntity account;

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public WebUserEntity() {
    }

    public WebUserEntity(Integer id, String firstName, String lastName, String username, String password, UserState state) {
        super(id, firstName, lastName, username, password, state);
    }

    public WebUserEntity(String firstName, String lastName, String username, String password, UserState state) {
        super(firstName, lastName, username, password, state);
    }

    public WebUserEntity(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }




}
