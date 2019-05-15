package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.AccountDTO;
import com.ivans.webshop.dto.CompanyDTO;
import com.ivans.webshop.dto.LineItemDTO;
import com.ivans.webshop.dto.OrderDTO;
import com.ivans.webshop.dto.PaymentDTO;
import com.ivans.webshop.dto.PaymentDetailsDTO;
import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.repository.entity.AccountEntity;
import com.ivans.webshop.repository.entity.CompanyEntity;
import com.ivans.webshop.repository.entity.LineItemEntity;
import com.ivans.webshop.repository.entity.OrderEntity;
import com.ivans.webshop.repository.entity.PaymentDetailsEntity;
import com.ivans.webshop.repository.entity.PaymentEntity;
import com.ivans.webshop.repository.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-15T20:24:35+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDTO account2DTO(AccountEntity account) {
        if ( account == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setPaymentDetails( paymentDetailsEntityListToPaymentDetailsDTOList( account.getPaymentDetails() ) );
        accountDTO.setName( account.getName() );
        accountDTO.setClosed( account.getClosed() );
        accountDTO.setOpened( account.getOpened() );
        accountDTO.setOrders( orderEntityListToOrderDTOList( account.getOrders() ) );

        return accountDTO;
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

    protected List<PaymentDetailsDTO> paymentDetailsEntityListToPaymentDetailsDTOList(List<PaymentDetailsEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PaymentDetailsDTO> list1 = new ArrayList<PaymentDetailsDTO>( list.size() );
        for ( PaymentDetailsEntity paymentDetailsEntity : list ) {
            list1.add( paymentDetailsEntityToPaymentDetailsDTO( paymentDetailsEntity ) );
        }

        return list1;
    }

    protected CompanyDTO companyEntityToCompanyDTO(CompanyEntity companyEntity) {
        if ( companyEntity == null ) {
            return null;
        }

        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setCountry( companyEntity.getCountry() );
        companyDTO.setCity( companyEntity.getCity() );
        companyDTO.setName( companyEntity.getName() );

        return companyDTO;
    }

    protected ProductDTO productEntityToProductDTO(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setName( productEntity.getName() );
        productDTO.setPrice( productEntity.getPrice() );
        productDTO.setTax( productEntity.getTax() );
        productDTO.setDiscount( productEntity.getDiscount() );
        if ( productEntity.getCategory() != null ) {
            productDTO.setCategory( productEntity.getCategory().name() );
        }
        productDTO.setCompany( companyEntityToCompanyDTO( productEntity.getCompany() ) );

        return productDTO;
    }

    protected LineItemDTO lineItemEntityToLineItemDTO(LineItemEntity lineItemEntity) {
        if ( lineItemEntity == null ) {
            return null;
        }

        LineItemDTO lineItemDTO = new LineItemDTO();

        lineItemDTO.setQuantity( lineItemEntity.getQuantity() );
        lineItemDTO.setDiscount( lineItemEntity.getDiscount() );
        lineItemDTO.setPrice( lineItemEntity.getPrice() );
        lineItemDTO.setProduct( productEntityToProductDTO( lineItemEntity.getProduct() ) );

        return lineItemDTO;
    }

    protected List<LineItemDTO> lineItemEntityListToLineItemDTOList(List<LineItemEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<LineItemDTO> list1 = new ArrayList<LineItemDTO>( list.size() );
        for ( LineItemEntity lineItemEntity : list ) {
            list1.add( lineItemEntityToLineItemDTO( lineItemEntity ) );
        }

        return list1;
    }

    protected PaymentDTO paymentEntityToPaymentDTO(PaymentEntity paymentEntity) {
        if ( paymentEntity == null ) {
            return null;
        }

        PaymentDTO paymentDTO = new PaymentDTO();

        paymentDTO.setTotal( paymentEntity.getTotal() );
        paymentDTO.setDetails( paymentEntity.getDetails() );
        paymentDTO.setPaymentDetails( paymentDetailsEntityToPaymentDetailsDTO( paymentEntity.getPaymentDetails() ) );

        return paymentDTO;
    }

    protected OrderDTO orderEntityToOrderDTO(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrdered( orderEntity.getOrdered() );
        orderDTO.setShipped( orderEntity.getShipped() );
        orderDTO.setStatus( orderEntity.getStatus() );
        orderDTO.setTotal( orderEntity.getTotal() );
        orderDTO.setLineItems( lineItemEntityListToLineItemDTOList( orderEntity.getLineItems() ) );
        orderDTO.setPayment( paymentEntityToPaymentDTO( orderEntity.getPayment() ) );

        return orderDTO;
    }

    protected List<OrderDTO> orderEntityListToOrderDTOList(List<OrderEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDTO> list1 = new ArrayList<OrderDTO>( list.size() );
        for ( OrderEntity orderEntity : list ) {
            list1.add( orderEntityToOrderDTO( orderEntity ) );
        }

        return list1;
    }
}
