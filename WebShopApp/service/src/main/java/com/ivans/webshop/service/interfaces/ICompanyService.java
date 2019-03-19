package com.ivans.webshop.service.interfaces;

import com.ivans.webshop.dto.CompanyDTO;
import com.ivans.webshop.repository.entity.CompanyEntity;

import java.util.List;

public interface ICompanyService {

    List<CompanyDTO> getAllCompanies();

    CompanyDTO getCompanyById(int companyId) throws Exception;

    CompanyDTO getCompanyByName(String companyName) throws Exception;

    void addCompany(CompanyEntity company);

    void deleteCompany(Integer id) throws Exception;

    void updateCompany(CompanyEntity company, Integer companyId) throws Exception;

}
