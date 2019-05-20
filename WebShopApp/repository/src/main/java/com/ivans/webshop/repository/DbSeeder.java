package com.ivans.webshop.repository;

import com.ivans.webshop.repository.entity.*;
import com.ivans.webshop.repository.enums.ProductCategory;
import com.ivans.webshop.repository.enums.UserState;
import com.ivans.webshop.repository.repo.CompanyRepo;
import com.ivans.webshop.repository.repo.ProductRepo;
import com.ivans.webshop.repository.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private ProductRepo productRepo;


    @Override
    public void run(String... args) throws Exception {

        CompanyEntity com1 = new CompanyEntity("Serbia", "Belgrade", "Nordeus");
        CompanyEntity com2 = new CompanyEntity("Serbia", "Belgrade", "7 Bridges Genomics");
        CompanyEntity com3 = new CompanyEntity("Serbia", "Belgrade", "Saga");


        CompanyUserEntity c1 = new CompanyUserEntity("Milka", "Canic", "srda", "123", UserState.New);
        CompanyUserEntity c2 = new CompanyUserEntity("Pera", "Peric", "pera", "123", UserState.New);
        WebUserEntity w1 = new WebUserEntity("Mita", "Mitic", "mita", "123", UserState.New);

//        ProductEntity p1 = new ProductEntity("Snowboard 1", "/resources/images/3", 290, 0.4, 0.1, null, com1);
//        ProductEntity p4 = new ProductEntity("Snowboard 2","/resources/images/8", 290, 0.4, 0.1, null, com1);
//        ProductEntity p2 = new ProductEntity("Ski Hoodie","/resources/images/board5", 290, 0.4, 0.1, null, com2);
//        ProductEntity p3 = new ProductEntity("Ski Set","/resources/images/e1", 290, 0.4, 0.1, null, com3);

        ProductEntity p1 = new ProductEntity("Snowboard 1", "/resources/images/3.jpg", 290, 0.4, 0.1, ProductCategory.SNOWBOARDS, com1);
        ProductEntity p2 = new ProductEntity("Snowboard 2","/resources/images/8.jpg", 290, 0.4, 0.1, ProductCategory.SNOWBOARDS, com1);
        c1.setCompany(com1);
        c2.setCompany(com2);

        List<UserEntity> users = new ArrayList<UserEntity>();
        users.add(c1);
        users.add(c2);
        users.add(w1);

        List<CompanyEntity> companies = new ArrayList<CompanyEntity>();
        companies.add(com1);
        companies.add(com2);
        companies.add(com3);

        List<ProductEntity> products = new ArrayList<ProductEntity>();
        products.add(p1);
        products.add(p2);
//        products.add(p3);
//        products.add(p4);

        companyRepo.saveAll(companies);
        userRepo.saveAll(users);
        productRepo.saveAll(products);

    }
}
