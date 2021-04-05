package eti.br.webstuff.apispringbootaws.converters;

import eti.br.webstuff.apispringbootaws.entity.User;
import eti.br.webstuff.apispringbootaws.resource.dto.request.UserSavedto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User converterUserSavedtoToUSer(UserSavedto userSavedto){
        return User.builder()
                   .name(userSavedto.getName())
                   .email(userSavedto.getEmail())
                   .password(userSavedto.getPassword())
                   .phone(userSavedto.getPhone())
                   .roleEnum(userSavedto.getRole())
                   .build();
    }
}
