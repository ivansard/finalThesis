package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.CompanyDTO;
import com.ivans.webshop.repository.entity.CompanyEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-15T20:24:35+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyDTO company2DTO(CompanyEntity company) {
        if ( company == null ) {
            return null;
        }

        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setCountry( company.getCountry() );
        companyDTO.setCity( company.getCity() );
        companyDTO.setName( company.getName() );

        return companyDTO;
    }
}
