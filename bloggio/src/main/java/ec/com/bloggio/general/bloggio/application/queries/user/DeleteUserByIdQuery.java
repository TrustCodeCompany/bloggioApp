package ec.com.bloggio.general.bloggio.application.queries.user;

import ec.com.bloggio.general.bloggio.domain.entities.User;

import io.jkratz.mediator.core.Request;
import lombok.Data;

/**
* Entity for Query DeleteUserById
 * @author trustcode
 * @version 1.0
 */

@Data
public class DeleteUserByIdQuery implements Request<User>{
    private Long userId;
}
