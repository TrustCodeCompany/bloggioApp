package ec.com.bloggio.general.bloggio.application.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

/**
 * Entity for Request CreateUser
 * @author trustcode
 * @version 1.0
 */

@Getter
@Setter
public class CreateUserRequest {
    private Long id;
    @NotBlank(message = "campo nombre es requerido.")
    private String name;
    @NotBlank(message = "campo usuario es requerido")
    private String user;
}
