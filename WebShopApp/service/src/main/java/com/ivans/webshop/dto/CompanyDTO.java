package com.ivans.webshop.dto;

import java.util.ArrayList;
import java.util.List;

public class CompanyDTO {

    private String country;
    private String city;
    private String name;
//    private List<CompanyUserDTO> companyUsers = new ArrayList<CompanyUserDTO>();
    private List<ProductDTO> products = new ArrayList<ProductDTO>();

    public CompanyDTO() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<CompanyUserDTO> getCompanyUsers() {
//        return companyUsers;
//    }
//
//    public void setCompanyUsers(List<CompanyUserDTO> companyUsers) {
//        this.companyUsers = companyUsers;
//    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }


}
