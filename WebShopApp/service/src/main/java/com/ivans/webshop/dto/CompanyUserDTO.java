package com.ivans.webshop.dto;

public class CompanyUserDTO extends UserDTO {

    private CompanyDTO company;

    public CompanyUserDTO() {
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }
}
