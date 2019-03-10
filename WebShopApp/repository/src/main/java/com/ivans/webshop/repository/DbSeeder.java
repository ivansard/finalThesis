package com.ivans.webshop.repository;

import com.ivans.webshop.repository.entity.CompanyUser;
import com.ivans.webshop.repository.entity.User;
import com.ivans.webshop.repository.entity.WebUser;
import com.ivans.webshop.repository.enums.UserState;
import com.ivans.webshop.repository.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private UserRepo userRepo;

    @Autowired
    public DbSeeder(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {
//        CompanyUser c1 = new CompanyUser("Milka", "Canic", "srda", "123", UserState.New);
//        CompanyUser c2 = new CompanyUser("Pera", "Peric", "pera", "123", UserState.New);
//        WebUser w1 = new WebUser("Mita", "Mitic", "mita", "123", UserState.New);
////        CompanyUser c2 = new CompanyUser();
////        WebUser w1 = new WebUser();
//
//
//        List<User> users = new ArrayList<>();
//        users.add(c1);
//        users.add(c2);
//        users.add(w1);
//
//        userRepo.saveAll(users);

    }
}
