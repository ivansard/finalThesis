package com.ivans.webshop.repository.entity;

import com.ivans.webshop.repository.enums.UserState;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class WebUser extends User{

    public WebUser() {
    }

    public WebUser(Integer id, String firstName, String lastName, String username, String password, UserState state) {
        super(id, firstName, lastName, username, password, state);
    }

    public WebUser(String firstName, String lastName, String username, String password, UserState state) {
        super(firstName, lastName, username, password, state);
    }

    public WebUser(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }
}
