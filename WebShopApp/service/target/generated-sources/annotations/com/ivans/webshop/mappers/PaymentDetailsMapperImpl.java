package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.PaymentDetailsDTO;
import com.ivans.webshop.repository.entity.PaymentDetailsEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-15T20:24:35+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
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
        paymentDetailsDTO.setExpirationDate( paymentDetails.getExpirationDate() );
        paymentDetailsDTO.setSecurityCode( paymentDetails.getSecurityCode() );

        return paymentDetailsDTO;
    }
}
