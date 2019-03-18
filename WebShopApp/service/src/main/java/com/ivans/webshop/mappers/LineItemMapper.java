package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.LineItemDTO;
import com.ivans.webshop.repository.entity.LineItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LineItemMapper {

    @Mapping(target = "totalPrice", expression = "java(lineItem.getQuantity() * lineItem.getPrice() * lineItem.getDiscount())")
    LineItemDTO lineItem2DTO(LineItemEntity lineItem);

}
