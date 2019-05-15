package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.CompanyDTO;
import com.ivans.webshop.dto.LineItemDTO;
import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.repository.entity.CompanyEntity;
import com.ivans.webshop.repository.entity.LineItemEntity;
import com.ivans.webshop.repository.entity.ProductEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-15T20:24:35+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class LineItemMapperImpl implements LineItemMapper {

    @Override
    public LineItemDTO lineItem2DTO(LineItemEntity lineItem) {
        if ( lineItem == null ) {
            return null;
        }

        LineItemDTO lineItemDTO = new LineItemDTO();

        lineItemDTO.setQuantity( lineItem.getQuantity() );
        lineItemDTO.setDiscount( lineItem.getDiscount() );
        lineItemDTO.setPrice( lineItem.getPrice() );
        lineItemDTO.setProduct( productEntityToProductDTO( lineItem.getProduct() ) );

        lineItemDTO.setTotalPrice( lineItem.getQuantity() * lineItem.getPrice() * lineItem.getDiscount() );

        return lineItemDTO;
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
}
