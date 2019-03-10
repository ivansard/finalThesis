package com.ivans.webshop.services;

import com.ivans.webshop.repository.entity.Company;
import com.ivans.webshop.repository.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    public List<Company> getAllCompanies(){
        return companyRepo.findAll();
    }
}
