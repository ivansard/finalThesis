package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.AccountDTO;
import com.ivans.webshop.dto.CompanyDTO;
import com.ivans.webshop.dto.LineItemDTO;
import com.ivans.webshop.dto.OrderDTO;
import com.ivans.webshop.dto.PaymentDetailsDTO;
import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.repository.entity.AccountEntity;
import com.ivans.webshop.repository.entity.CompanyEntity;
import com.ivans.webshop.repository.entity.LineItemEntity;
import com.ivans.webshop.repository.entity.OrderEntity;
import com.ivans.webshop.repository.entity.PaymentDetailsEntity;
import com.ivans.webshop.repository.entity.ProductEntity;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-06T21:05:43+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.3 (JetBrains s.r.o)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDTO account2DTO(AccountEntity account) {
        if ( account == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setPaymentDetails( paymentDetailsEntityToPaymentDetailsDTO( account.getPaymentDetails() ) );
        accountDTO.setName( account.getName() );
        if ( account.getClosed() != null ) {
            accountDTO.setClosed( LocalDateTime.ofInstant( account.getClosed().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        if ( account.getOpened() != null ) {
            accountDTO.setOpened( LocalDateTime.ofInstant( account.getOpened().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        accountDTO.setOrders( orderEntityListToOrderDTOList( account.getOrders() ) );

        return accountDTO;
    }

    protected PaymentDetailsDTO paymentDetailsEntityToPaymentDetailsDTO(PaymentDetailsEntity paymentDetailsEntity) {
        if ( paymentDetailsEntity == null ) {
            return null;
        }

        PaymentDetailsDTO paymentDetailsDTO = new PaymentDetailsDTO();

        paymentDetailsDTO.setCardNumber( paymentDetailsEntity.getCardNumber() );
        if ( paymentDetailsEntity.getExpirationDate() != null ) {
            paymentDetailsDTO.setExpirationDate( LocalDateTime.ofInstant( paymentDetailsEntity.getExpirationDate().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        paymentDetailsDTO.setSecurityCode( paymentDetailsEntity.getSecurityCode() );

        return paymentDetailsDTO;
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

        productDTO.setId( productEntity.getId() );
        productDTO.setImageUrl( productEntity.getImageUrl() );
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
        lineItemDTO.setTotalPrice( lineItemEntity.getTotalPrice() );
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

    protected OrderDTO orderEntityToOrderDTO(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        if ( orderEntity.getOrdered() != null ) {
            orderDTO.setOrdered( LocalDateTime.ofInstant( orderEntity.getOrdered().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        if ( orderEntity.getShipped() != null ) {
            orderDTO.setShipped( LocalDateTime.ofInstant( orderEntity.getShipped().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        orderDTO.setStatus( orderEntity.getStatus() );
        orderDTO.setTotal( orderEntity.getTotal() );
        orderDTO.setLineItems( lineItemEntityListToLineItemDTOList( orderEntity.getLineItems() ) );

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
