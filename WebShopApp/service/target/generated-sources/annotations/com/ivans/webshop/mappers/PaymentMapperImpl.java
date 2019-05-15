package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.PaymentDTO;
import com.ivans.webshop.dto.PaymentDetailsDTO;
import com.ivans.webshop.repository.entity.PaymentDetailsEntity;
import com.ivans.webshop.repository.entity.PaymentEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-15T20:24:35+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentDTO payment2DTO(PaymentEntity payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDTO paymentDTO = new PaymentDTO();

        paymentDTO.setTotal( payment.getTotal() );
        paymentDTO.setDetails( payment.getDetails() );
        paymentDTO.setPaymentDetails( paymentDetailsEntityToPaymentDetailsDTO( payment.getPaymentDetails() ) );

        return paymentDTO;
    }

    protected PaymentDetailsDTO paymentDetailsEntityToPaymentDetailsDTO(PaymentDetailsEntity paymentDetailsEntity) {
        if ( paymentDetailsEntity == null ) {
            return null;
        }

        PaymentDetailsDTO paymentDetailsDTO = new PaymentDetailsDTO();

        paymentDetailsDTO.setCardNumber( paymentDetailsEntity.getCardNumber() );
        paymentDetailsDTO.setExpirationDate( paymentDetailsEntity.getExpirationDate() );
        paymentDetailsDTO.setSecurityCode( paymentDetailsEntity.getSecurityCode() );

        return paymentDetailsDTO;
    }
}
