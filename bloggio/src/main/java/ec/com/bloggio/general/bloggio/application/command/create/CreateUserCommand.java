package ec.com.bloggio.general.bloggio.application.command.create;

import ec.com.bloggio.general.bloggio.application.dto.request.CreateUserRequest;
import ec.com.bloggio.general.bloggio.application.dto.response.CreateUserResponse;

import io.jkratz.mediator.core.Request;

/**
 * Entity for Command CreateUser
 * @author trustcode
 * @version 1.0
 */

public class CreateUserCommand extends CreateUserRequest implements Request<CreateUserResponse> {
    public CreateUserCommand(){
        super();
    }
}
