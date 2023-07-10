package ec.com.bloggio.general.bloggio.application.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity for Response CreateUser
 * @author trustcode
 * @version 1.0
 */

@Getter
@Setter
public class CreateUserResponse {
    private long userId;
    public CreateUserResponse(long userId){
        this.userId=userId;
    }
}
