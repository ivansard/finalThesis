package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.repository.entity.CompanyEntity;

import java.util.List;

public interface ICompanyService {

    List<CompanyEntity> getAllCompanies();

    CompanyEntity getCompanyById(int companyId);

    CompanyEntity getCompanyByName(String companyName);

    void addCompany(CompanyEntity company);

    void deleteCompany(Integer id);

    void updateCompany(CompanyEntity company, Integer companyId);

}
