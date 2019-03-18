package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.CompanyDTO;
import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.repository.entity.CompanyEntity;
import com.ivans.webshop.repository.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-03-18T20:29:35+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO product2DTO(ProductEntity product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setName( product.getName() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setTax( product.getTax() );
        productDTO.setDiscount( product.getDiscount() );
        if ( product.getCategory() != null ) {
            productDTO.setCategory( product.getCategory().name() );
        }
        productDTO.setCompany( companyEntityToCompanyDTO( product.getCompany() ) );

        return productDTO;
    }

    protected List<ProductDTO> productEntityListToProductDTOList(List<ProductEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductDTO> list1 = new ArrayList<ProductDTO>( list.size() );
        for ( ProductEntity productEntity : list ) {
            list1.add( product2DTO( productEntity ) );
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
        companyDTO.setProducts( productEntityListToProductDTOList( companyEntity.getProducts() ) );

        return companyDTO;
    }
}
