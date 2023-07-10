package ec.com.bloggio.general.bloggio.application.command.update;

import io.jkratz.mediator.core.RequestHandler;
import ec.com.bloggio.general.bloggio.application.dto.response.UpdateUserResponse;
import ec.com.bloggio.general.bloggio.domain.entities.User;
import ec.com.bloggio.general.bloggio.domain.interfaces.IUserRepository;
import ec.com.bloggio.general.bloggio.domain.exceptions.UserNotExistsException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Entity for Command UpdateUserHandler
 * @author trustcode
 * @version 1.0
 */

@Component
public class UpdateUserCommandHandler implements RequestHandler<UpdateUserCommand, UpdateUserResponse> {
    @Autowired
    private IUserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UpdateUserCommandHandler.class);

    @Override
    @Transactional
    public UpdateUserResponse handle(UpdateUserCommand updateUserCommand) {
        long id = 0L;
        logger.info("Entra a la operacion UpdateUserCommandHandler...");
        var userFind = userRepository.findById(updateUserCommand.getId());
        if ( userFind == null){
            throw new UserNotExistsException(String.format("El usuario con id %s no existe",updateUserCommand.getId()));
        }

        User user = new User();
        user.setId(updateUserCommand.getId());
        user.setName(updateUserCommand.getName());
        user.setCreateUser(userFind.getCreateUser());
        user.setCreatedAt(userFind.getCreatedAt());
        user.setUpdateUser(updateUserCommand.getUser());
        user.setIsActive(updateUserCommand.getIsActive());
        id = userRepository.save(user);

        
        logger.info("Fin de la operacion UpdateUserCommandHandler...");
        return new UpdateUserResponse(id);
    }

}
