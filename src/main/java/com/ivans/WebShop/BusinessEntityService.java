/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivans.WebShop;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ivan
 */
@Service
public class BusinessEntityService {

    @Autowired
    private BusinessEntityRepository businessEntityRepository;
    
    public List<BusinessEntity> getAllBusinessEntities() {
        
        List<BusinessEntity> businessEntities = new ArrayList<>();
        
        businessEntityRepository.findAll()
                .forEach(businessEntities::add);
        
        return businessEntities;
    }

    public void addBusiness(BusinessEntity business) {
        businessEntityRepository.save(business);
    }

    public BusinessEntity getBusinessById(Integer id) {
        return businessEntityRepository.findById(id).orElse(null);
    }

    void deleteBusiness(Integer id) {
        businessEntityRepository.deleteById(id);
    }

    void updateBusiness(BusinessEntity business, Integer id) {
        businessEntityRepository.save(business);
    }
    
}
