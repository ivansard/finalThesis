package com.ivans.webshop.app;

import com.ivans.webshop.dto.CompanyDTO;
import com.ivans.webshop.dto.CompanyUserDTO;
import com.ivans.webshop.dto.UserDTO;
import com.ivans.webshop.mappers.CompanyMapper;
import com.ivans.webshop.mappers.CompanyUserMapper;
import com.ivans.webshop.mappers.UserMapper;
import com.ivans.webshop.repository.entity.CompanyEntity;
import com.ivans.webshop.repository.entity.CompanyUserEntity;
import com.ivans.webshop.repository.entity.UserEntity;
import com.ivans.webshop.repository.enums.UserState;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ivans.webshop.repository"})
@EntityScan(basePackages = {"com.ivans.webshop.repository"})
@ComponentScan(basePackages = {"com.ivans.webshop"})
public class WebshopApplication {

    public static void main(String[] args) {

        CompanyEntity company = new CompanyEntity("Serbia", "Belgrade", "Levi9");

        CompanyUserEntity user = new CompanyUserEntity("Pera", "Peric", "rape", "123", UserState.New);
        CompanyUserEntity user2 = new CompanyUserEntity("Ivan", "Peric", "ivan", "123", UserState.New);
        user.setCompany(company);

        List<CompanyUserEntity> companyUsers = new ArrayList<CompanyUserEntity>();
        companyUsers.add(user);
        companyUsers.add(user2);

        company.setCompanyUsers(companyUsers);


        CompanyUserMapper mapper = Mappers.getMapper(CompanyUserMapper.class);
        CompanyMapper comMapper =  Mappers.getMapper(CompanyMapper.class);

//        CompanyUserDTO dto = mapper.companyUser2DTO(user);
//
//        System.out.println(dto.getName());
//        System.out.println(dto.getUsername());
//        System.out.println(dto.getCompany().getCountry());

        CompanyDTO comDTO = comMapper.company2DTO(company);

        System.out.println(comDTO.getName());
        System.out.println(comDTO.getCountry());

        CompanyUserDTO dto = mapper.companyUser2DTO(user);

        System.out.println(dto.getName());
        System.out.println(dto.getUsername());
        System.out.println(dto.getCompany().getCountry());



        SpringApplication.run(WebshopApplication.class);
    }
}
