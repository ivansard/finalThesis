package com.ivans.webshop.services;

import com.ivans.webshop.repository.entity.CompanyEntity;
import com.ivans.webshop.repository.repo.CompanyRepo;
import com.ivans.webshop.service.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    public List<CompanyEntity> getAllCompanies(){
        return companyRepo.findAll();
    }

    @Override
    public CompanyEntity getCompanyById(int companyId) {
        return companyRepo.findById(companyId).orElse(null);
    }

    @Override
    public CompanyEntity getCompanyByName(String companyName) {
        return companyRepo.findByName(companyName);
    }

    @Override
    public void addCompany(CompanyEntity company) {
        companyRepo.save(company);
    }

    @Override
    public void deleteCompany(Integer companyId) {
        companyRepo.deleteById(companyId);
    }

    @Override
    public void updateCompany(CompanyEntity company, Integer companyId) {
        companyRepo.save(company);
    }
}
