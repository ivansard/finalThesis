/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivans.WebShop;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ivan
 */
@RestController
public class BusinessEntityController {
    
    @Autowired
    private BusinessEntityService businessEntityService;
    
    @RequestMapping("/businesses")
    public List<BusinessEntity> getAllBusinessEntities(){
        return businessEntityService.getAllBusinessEntities();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/businesses")
    public void addBussinessEntity(@RequestBody BusinessEntity business){
        businessEntityService.addBusiness(business);
    }
    
    @RequestMapping("/businesses/{id}")
    public BusinessEntity getBusinessById(@PathVariable Integer id){
        return businessEntityService.getBusinessById(id);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/businesses/{id}")
    public void deleteBusiness(@PathVariable Integer id){
        businessEntityService.deleteBusiness(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/businesses/{id}")
    public void updateBusiness(@RequestBody BusinessEntity business, @PathVariable Integer id){
        businessEntityService.updateBusiness(business, id);
    }
    
    
}
