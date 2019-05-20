package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.repository.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "discountPrice", expression = "java(product.getPrice() * (1 - product.getDiscount()))")
    ProductDTO product2DTO (ProductEntity product);

}
