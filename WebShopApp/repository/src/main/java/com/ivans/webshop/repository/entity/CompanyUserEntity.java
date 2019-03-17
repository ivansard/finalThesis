package com.ivans.webshop.repository.entity;

import com.ivans.webshop.repository.enums.UserState;

import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
public class CompanyUserEntity extends UserEntity {

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    public CompanyUserEntity() {
    }

    public CompanyUserEntity(Integer id, String firstName, String lastName, String username, String password, UserState state) {
        super(id, firstName, lastName, username, password, state);
    }

    public CompanyUserEntity(String firstName, String lastName, String username, String password, UserState state) {
        super(firstName, lastName, username, password, state);
    }

    public CompanyUserEntity(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    public CompanyUserEntity(Integer id, String firstName, String lastName, String username, String password, UserState state, CompanyEntity company) {
        super(id, firstName, lastName, username, password, state);
        this.company = company;
    }

    public CompanyUserEntity(String firstName, String lastName, String username, String password, UserState state, CompanyEntity company) {
        super(firstName, lastName, username, password, state);
        this.company = company;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
}
