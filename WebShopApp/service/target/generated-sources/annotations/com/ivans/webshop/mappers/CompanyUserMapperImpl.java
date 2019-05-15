package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.CompanyDTO;
import com.ivans.webshop.dto.CompanyUserDTO;
import com.ivans.webshop.repository.entity.CompanyEntity;
import com.ivans.webshop.repository.entity.CompanyUserEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-15T20:24:35+0200",
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
}
