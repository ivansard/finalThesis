package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.repository.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO product2DTO (ProductEntity product);
}
