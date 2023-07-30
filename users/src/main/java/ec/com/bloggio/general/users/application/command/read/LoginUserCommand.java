package ec.com.bloggio.general.users.application.command.read;

import ec.com.bloggio.general.users.application.dto.request.LoginUserRequest;
import ec.com.bloggio.general.users.application.dto.response.LoginUserResponse;
import io.jkratz.mediator.core.Request;

public class LoginUserCommand extends LoginUserRequest implements Request<LoginUserResponse> {
    public LoginUserCommand() {
        super();
    }
}
