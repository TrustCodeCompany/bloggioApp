package ec.com.bloggio.general.users.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginUserRequest {
    @NotBlank(message = "user field can't be empty.")
    private String email;
    @NotBlank(message = "Password field can't be empty.")
    private String pwd;

}
