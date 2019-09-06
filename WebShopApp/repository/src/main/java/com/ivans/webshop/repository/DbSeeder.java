package com.ivans.webshop.repository;

import com.ivans.webshop.repository.entity.*;
import com.ivans.webshop.repository.enums.OrderStatus;
import com.ivans.webshop.repository.enums.ProductCategory;
import com.ivans.webshop.repository.enums.UserState;
import com.ivans.webshop.repository.repo.CompanyRepo;
import com.ivans.webshop.repository.repo.OrderRepo;
import com.ivans.webshop.repository.repo.ProductRepo;
import com.ivans.webshop.repository.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private OrderRepo orderRepo;


    @Override
    public void run(String... args) throws Exception {

        CompanyEntity com1 = new CompanyEntity("Serbia", "Belgrade", "Nordeus");
        CompanyEntity com2 = new CompanyEntity("Serbia", "Belgrade", "7 Bridges Genomics");
        CompanyEntity com3 = new CompanyEntity("Serbia", "Belgrade", "Saga");


        CompanyUserEntity c1 = new CompanyUserEntity("Milka", "Canic", "srda", "123", UserState.New);
        CompanyUserEntity c2 = new CompanyUserEntity("Pera", "Peric", "pera", "123", UserState.New);
        WebUserEntity w1 = new WebUserEntity("Mita", "Mitic", "mita", "123", UserState.New);

        ProductEntity p1 = new ProductEntity("Snowboard 1", "/resources/images/pic8.jpg", 290, 0.4, 0.1, null, com1);
        ProductEntity p4 = new ProductEntity("Snowboard 2","/resources/images/pic12.jpg", 170, 0.4, 0.1, null, com1);
        ProductEntity p2 = new ProductEntity("Ski Hoodie","/resources/images/pic5.jpg", 35, 0.4, 0.1, null, com2);
        ProductEntity p3 = new ProductEntity("Ski Set","/resources/images/pic1.jpg", 120, 0.4, 0.1, null, com3);

        ProductEntity p5 = new ProductEntity("Snowboard 1", "/resources/images/pic8.jpg", 290, 0.4, 0.1, null, com1);
        ProductEntity p6 = new ProductEntity("Snowboard 2","/resources/images/pic12.jpg", 170, 0.4, 0.1, null, com1);
        ProductEntity p7 = new ProductEntity("Ski Hoodie","/resources/images/pic5.jpg", 35, 0.4, 0.1, null, com2);
        ProductEntity p8 = new ProductEntity("Ski Set","/resources/images/pic1.jpg", 120, 0.4, 0.1, null, com3);

        ProductEntity p9 = new ProductEntity("Snowboard 1", "/resources/images/pic8.jpg", 290, 0.4, 0.1, null, com1);
        ProductEntity p10 = new ProductEntity("Snowboard 2","/resources/images/pic12.jpg", 170, 0.4, 0.1, null, com1);
        ProductEntity p11 = new ProductEntity("Ski Hoodie","/resources/images/pic5.jpg", 35, 0.4, 0.1, null, com2);
        ProductEntity p12 = new ProductEntity("Ski Set","/resources/images/pic1.jpg", 120, 0.4, 0.1, null, com3);

        ProductEntity p13 = new ProductEntity("Snowboard 1", "/resources/images/pic8.jpg", 290, 0.4, 0.1, null, com1);
        ProductEntity p14 = new ProductEntity("Snowboard 2","/resources/images/pic12.jpg", 170, 0.4, 0.1, null, com1);
        ProductEntity p15 = new ProductEntity("Ski Hoodie","/resources/images/pic5.jpg", 35, 0.4, 0.1, null, com2);
        ProductEntity p16 = new ProductEntity("Ski Set","/resources/images/pic1.jpg", 120, 0.4, 0.1, null, com3);

        OrderEntity o1 = new OrderEntity(new Date(), null, OrderStatus.NEW, 3000, new AccountEntity(3));

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
        products.add(p3);
        products.add(p5);
        products.add(p4);
        products.add(p6);
        products.add(p7);
        products.add(p9);
        products.add(p8);
        products.add(p11);
        products.add(p12);
        products.add(p10);
        products.add(p13);
        products.add(p14);
        products.add(p15);
        products.add(p16);

        companyRepo.saveAll(companies);
        userRepo.saveAll(users);
        productRepo.saveAll(products);
        orderRepo.save(o1);

    }
}
