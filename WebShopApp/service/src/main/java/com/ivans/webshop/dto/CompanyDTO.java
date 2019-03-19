package com.ivans.webshop.dto;

import java.util.ArrayList;
import java.util.List;

public class CompanyDTO {

    private String country;
    private String city;
    private String name;
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



}
