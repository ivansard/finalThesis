package com.ivans.webshop.services;

import com.ivans.webshop.dto.CompanyDTO;
import com.ivans.webshop.mappers.CompanyMapper;
import com.ivans.webshop.repository.entity.CompanyEntity;
import com.ivans.webshop.repository.repo.CompanyRepo;
import com.ivans.webshop.service.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private CompanyMapper companyMapper;

    public List<CompanyDTO> getAllCompanies(){
        List<CompanyEntity> companyEntities = companyRepo.findAll();
        List<CompanyDTO> companyDTOs = new ArrayList<CompanyDTO>();
        for (CompanyEntity companyEntity: companyEntities) {
            companyDTOs.add(companyMapper.company2DTO(companyEntity));
        }
        return companyDTOs;
    }

    @Override
    public CompanyDTO getCompanyById(int companyId) throws Exception{
        CompanyEntity company = companyRepo.findById(companyId).orElse(null);
        if(company.equals(null)){
            throw new Exception("Account with submitted ID does not exist");
        }
        return companyMapper.company2DTO(company);
    }

    @Override
    public CompanyDTO getCompanyByName(String companyName) throws Exception{
        CompanyEntity company = companyRepo.findByName(companyName);
        if(company.equals(null)){
            throw new Exception("Account with submitted ID does not exist");
        }
        return companyMapper.company2DTO(company);
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
