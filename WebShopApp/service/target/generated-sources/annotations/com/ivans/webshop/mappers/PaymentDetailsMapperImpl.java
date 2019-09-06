package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.PaymentDetailsDTO;
import com.ivans.webshop.repository.entity.PaymentDetailsEntity;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-06T21:05:43+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.3 (JetBrains s.r.o)"
)
@Component
public class PaymentDetailsMapperImpl implements PaymentDetailsMapper {

    @Override
    public PaymentDetailsDTO paymentDetails2DTO(PaymentDetailsEntity paymentDetails) {
        if ( paymentDetails == null ) {
            return null;
        }

        PaymentDetailsDTO paymentDetailsDTO = new PaymentDetailsDTO();

        paymentDetailsDTO.setCardNumber( paymentDetails.getCardNumber() );
        if ( paymentDetails.getExpirationDate() != null ) {
            paymentDetailsDTO.setExpirationDate( LocalDateTime.ofInstant( paymentDetails.getExpirationDate().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        paymentDetailsDTO.setSecurityCode( paymentDetails.getSecurityCode() );

        return paymentDetailsDTO;
    }
}
