package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.WebUserDTO;
import com.ivans.webshop.repository.entity.WebUserEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-06T21:05:43+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.3 (JetBrains s.r.o)"
)
@Component
public class WebUserMapperImpl implements WebUserMapper {

    @Override
    public WebUserDTO webUser2DTO(WebUserEntity webUser) {
        if ( webUser == null ) {
            return null;
        }

        WebUserDTO webUserDTO = new WebUserDTO();

        webUserDTO.setPassword( webUser.getPassword() );
        webUserDTO.setUsername( webUser.getUsername() );
        if ( webUser.getState() != null ) {
            webUserDTO.setState( webUser.getState().name() );
        }

        webUserDTO.setName( webUser.getFirstName() + " " + webUser.getLastName() );

        return webUserDTO;
    }
}
