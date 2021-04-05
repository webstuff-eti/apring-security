package eti.br.webstuff.apispringbootaws.resource.dto.request;

import javax.validation.constraints.*;

import eti.br.webstuff.apispringbootaws.entity.Request;
import eti.br.webstuff.apispringbootaws.entity.RequestStage;
import eti.br.webstuff.apispringbootaws.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static eti.br.webstuff.apispringbootaws.configuration.validation.msn.ValidationProperties.*;

@Getter
@Setter
public class UserSavedto {

    @NotBlank (message = "Name required")
    @Pattern(regexp = REGEX_VALIDATION_FULL_NAME, message = INVALID_REGEX_VALIDATION_FULL_NAME) //TODO: Implementar validação utilizando Regex/ javax.validation.constraints
    private String name;

    @Email(message = "Invalid email address")
    private String email;

    @Size (min = 7, max = 99, message = "Password must be between 7 and 99")
    private String password;

    @Size (min = 9, max = 14, message = "Phonemust be between 9 and 14")
    private String phone;

    @NotNull(message = "Role required")
    private RoleEnum role;

    private List<Request> requests = new ArrayList<>();
    private List<RequestStage> stages = new ArrayList<>();

}
