package com.ivans.webshop.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String country;
    private String city;
    private String name;
    @OneToMany(mappedBy = "company")
    private List<CompanyUserEntity> companyUsers = new ArrayList<CompanyUserEntity>();
    @OneToMany(mappedBy = "company")
    List<ProductEntity> products = new ArrayList<ProductEntity>();


    public CompanyEntity() {
    }

    public CompanyEntity(String country, String city, String name) {
        this.country = country;
        this.city = city;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CompanyUserEntity> getCompanyUsers() {
        return companyUsers;
    }

    public void setCompanyUsers(List<CompanyUserEntity> companyUsers) {
        this.companyUsers = companyUsers;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
