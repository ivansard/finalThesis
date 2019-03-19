package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.PaymentDTO;
import com.ivans.webshop.repository.entity.PaymentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDTO payment2DTO(PaymentEntity payment);
}
