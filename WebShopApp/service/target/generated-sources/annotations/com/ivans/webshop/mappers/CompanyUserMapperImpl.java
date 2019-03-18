package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.CompanyDTO;
import com.ivans.webshop.dto.CompanyUserDTO;
import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.repository.entity.CompanyEntity;
import com.ivans.webshop.repository.entity.CompanyUserEntity;
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
public class CompanyUserMapperImpl implements CompanyUserMapper {

    @Override
    public CompanyUserDTO companyUser2DTO(CompanyUserEntity companyUser) {
        if ( companyUser == null ) {
            return null;
        }

        CompanyUserDTO companyUserDTO = new CompanyUserDTO();

        companyUserDTO.setUsername( companyUser.getUsername() );
        if ( companyUser.getState() != null ) {
            companyUserDTO.setState( companyUser.getState().name() );
        }
        companyUserDTO.setCompany( companyEntityToCompanyDTO( companyUser.getCompany() ) );

        companyUserDTO.setName( companyUser.getFirstName() + " " + companyUser.getLastName() );

        return companyUserDTO;
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

    protected List<ProductDTO> productEntityListToProductDTOList(List<ProductEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductDTO> list1 = new ArrayList<ProductDTO>( list.size() );
        for ( ProductEntity productEntity : list ) {
            list1.add( productEntityToProductDTO( productEntity ) );
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
