package com.ivans.webshop.repository.entity;

import com.ivans.webshop.repository.enums.UserState;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("2")
public class CompanyUser extends User{

    @OneToOne
    @Column(name = "fk_company")
    private Company company;

    public CompanyUser() {
    }

    public CompanyUser(Integer id, String firstName, String lastName, String username, String password, UserState state) {
        super(id, firstName, lastName, username, password, state);
    }

    public CompanyUser(String firstName, String lastName, String username, String password, UserState state) {
        super(firstName, lastName, username, password, state);
    }

    public CompanyUser(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public CompanyUser(Integer id, String firstName, String lastName, String username, String password, UserState state, Company company) {
        super(id, firstName, lastName, username, password, state);
        this.company = company;
    }

    public CompanyUser(String firstName, String lastName, String username, String password, UserState state, Company company) {
        super(firstName, lastName, username, password, state);
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
