package ec.com.bloggio.general.bloggio.application.command.update;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;
import ec.com.bloggio.general.bloggio.application.dto.request.UpdateUserRequest;
import ec.com.bloggio.general.bloggio.application.dto.response.UpdateUserResponse;

/**
 * Entity for Command UpdateUser
 * @author trustcode
 * @version 1.0
 */

@Getter
@Setter
public class UpdateUserCommand extends UpdateUserRequest implements Request<UpdateUserResponse> {
    public UpdateUserCommand(){
        super();
    }
}
