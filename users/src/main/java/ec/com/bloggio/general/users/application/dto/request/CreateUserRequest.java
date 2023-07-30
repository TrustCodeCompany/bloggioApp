package ec.com.bloggio.general.users.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateUserRequest {
    @NotBlank(message = "Name field can't be empty.")
    private String name;
    @NotBlank(message = "lastName field can't be empty.")
    private String lastName;
    private String photo;
    @NotBlank(message = "email field can't be empty.")
    private String email;
    @NotBlank(message = "password field can't be empty.")
    private String password;

    //private String[] role;
    public CreateUserRequest(){

    }

}
