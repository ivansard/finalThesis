package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.CompanyUserDTO;
import com.ivans.webshop.repository.entity.CompanyUserEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CompanyUserMapper {

    @Mapping(target = "name", expression = "java(companyUser.getFirstName() + \" \" + companyUser.getLastName())")
    CompanyUserDTO companyUser2DTO (CompanyUserEntity companyUser);

}
