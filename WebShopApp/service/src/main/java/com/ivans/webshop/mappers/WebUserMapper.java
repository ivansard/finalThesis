package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.WebUserDTO;
import com.ivans.webshop.repository.entity.WebUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WebUserMapper {

    @Mapping(target = "name", expression = "java(webUser.getFirstName() + \" \" + webUser.getLastName())")
    WebUserDTO webUser2DTO (WebUserEntity webUser);
}
