package com.ivans.webshop.controllers;

import com.ivans.webshop.repository.entity.Company;
import com.ivans.webshop.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }
}
