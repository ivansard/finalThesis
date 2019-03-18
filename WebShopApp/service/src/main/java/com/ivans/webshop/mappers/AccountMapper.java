package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.AccountDTO;
import com.ivans.webshop.repository.entity.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDTO account2DTO(AccountEntity account);
}
