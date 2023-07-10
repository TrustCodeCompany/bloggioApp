package ec.com.bloggio.general.bloggio.application.queries.user;

import org.springframework.stereotype.Component;

import ec.com.bloggio.general.bloggio.domain.interfaces.IUserRepository;
import ec.com.bloggio.general.bloggio.domain.entities.User;
import ec.com.bloggio.general.bloggio.domain.exceptions.UserNotExistsException;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Entity for Query GetUserByIdHandler
 * @author trustcode
 * @version 1.0
 */


@Component
public class GetUserByIdQueryHandler implements RequestHandler<GetUserByIdQuery, User> {
    

    @Autowired
    private IUserRepository userRepository;


    @Autowired
    private Mediator mediator;

    @Override
    public User handle(GetUserByIdQuery getUserByIdQuery) {
        User user = userRepository.findById(getUserByIdQuery.getUserId());
        if (user == null) {
            throw new UserNotExistsException(String.format("El usuario con id %s, no existe", getUserByIdQuery.getUserId()));
        }
        return user;
    }

}
