package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.OrderDTO;
import com.ivans.webshop.repository.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO order2DTO(OrderEntity order);
}
