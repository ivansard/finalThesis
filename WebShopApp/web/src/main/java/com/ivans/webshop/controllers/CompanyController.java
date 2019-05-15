package com.ivans.webshop.controllers;

import com.ivans.webshop.dto.CompanyDTO;
import com.ivans.webshop.repository.entity.CompanyEntity;
import com.ivans.webshop.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "/companies")
    public List<CompanyDTO> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping(value = "/companies/{id}")
    public CompanyDTO getCompanyById(@PathVariable Integer id) throws Exception {
        return companyService.getCompanyById(id);
    }

    @PostMapping(value = "/companies")
    public void addCompany(@RequestBody CompanyEntity company) {
        companyService.addCompany(company);
    }

    @PutMapping(value = "/companies/{id}")
    public void deleteCompany(@RequestBody CompanyEntity company, @PathVariable Integer id) {
        companyService.updateCompany(company, id);
    }

    @DeleteMapping(value = "/companies/{id}")
    public void deleteCompany(@PathVariable Integer id) {
        companyService.deleteCompany(id);
    }
}
