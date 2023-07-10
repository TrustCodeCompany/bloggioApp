package ec.com.bloggio.general.bloggio.application.queries.user;

import org.springframework.stereotype.Component;

import ec.com.bloggio.general.bloggio.domain.interfaces.IUserRepository;
import ec.com.bloggio.general.bloggio.domain.entities.User;
import ec.com.bloggio.general.bloggio.domain.exceptions.UserNotExistsException;


import io.jkratz.mediator.core.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Entity for Query DeleteUserByIdHandler
 * @author trustcode
 * @version 1.0
 */


@Component
public class DeleteUserByIdQueryHandler implements RequestHandler<DeleteUserByIdQuery, User> {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User handle(DeleteUserByIdQuery deleteUserByIdQuery) {
        User user = userRepository.findById(deleteUserByIdQuery.getUserId());
        if (user == null) {
            throw new UserNotExistsException(String.format("El usuario con id %s, no existe", deleteUserByIdQuery.getUserId()));
        }
        userRepository.delete(deleteUserByIdQuery.getUserId());
        return null;
    }
    
}
