package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.PaymentDetailsDTO;
import com.ivans.webshop.repository.entity.PaymentDetailsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentDetailsMapper {

    PaymentDetailsDTO paymentDetails2DTO(PaymentDetailsEntity paymentDetails);
}
