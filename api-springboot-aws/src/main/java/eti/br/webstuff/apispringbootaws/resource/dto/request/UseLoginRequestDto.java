package eti.br.webstuff.apispringbootaws.resource.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UseLoginRequestDto {

    private String email;
    private String password;

}
