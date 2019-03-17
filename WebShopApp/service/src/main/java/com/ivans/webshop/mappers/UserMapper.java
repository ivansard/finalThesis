package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.UserDTO;
import com.ivans.webshop.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "name", expression = "java(user.getFirstName() + \" \" + user.getLastName())")
    UserDTO user2DTO(UserEntity user);
}
