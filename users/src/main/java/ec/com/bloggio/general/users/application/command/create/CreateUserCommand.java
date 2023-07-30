package ec.com.bloggio.general.users.application.command.create;


import ec.com.bloggio.general.users.application.dto.request.CreateUserRequest;
import ec.com.bloggio.general.users.application.dto.response.CreateUserResponse;
import io.jkratz.mediator.core.Request;

public class CreateUserCommand extends CreateUserRequest implements Request<CreateUserResponse> {
    public CreateUserCommand() {
        super();
    }
}
