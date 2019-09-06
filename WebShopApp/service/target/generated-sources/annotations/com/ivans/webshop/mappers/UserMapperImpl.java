package com.ivans.webshop.mappers;

import com.ivans.webshop.dto.UserDTO;
import com.ivans.webshop.repository.entity.UserEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-09-06T21:05:43+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.3 (JetBrains s.r.o)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO user2DTO(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setPassword( user.getPassword() );
        userDTO.setUsername( user.getUsername() );
        if ( user.getState() != null ) {
            userDTO.setState( user.getState().name() );
        }

        userDTO.setName( user.getFirstName() + " " + user.getLastName() );

        return userDTO;
    }
}
