package sudakova.onlineshop.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserRequest {

    @NotNull
    @Email
    private String email;

    @NotNull
    @NotBlank
    private String password;

    private Integer type;
}
