package ec.com.bloggio.general.bloggio.application.command.create;

import io.jkratz.mediator.core.RequestHandler;
import ec.com.bloggio.general.bloggio.application.dto.response.CreateUserResponse;
import ec.com.bloggio.general.bloggio.domain.entities.User;
import ec.com.bloggio.general.bloggio.domain.interfaces.IUserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Entity for Command CreateUserHandler
 * @author trustcode
 * @version 1.0
 */

@Component
public class CreateUserCommandHandler implements RequestHandler<CreateUserCommand, CreateUserResponse> {
    
    @Autowired
    private IUserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(CreateUserCommandHandler.class);

    @Override
    @Transactional
    public CreateUserResponse handle(CreateUserCommand createUserCommand) {
        long userId = 0L;
        logger.info("Entra a la operacion CreateUserCommandHandler...");
        
            User user = new User();
            user.setName(createUserCommand.getName());
            user.setCreateUser(createUserCommand.getUser());
            userId = userRepository.save(user);
        
        logger.info("Fin de la operacion CreateUserCommandHandler...");
        return new CreateUserResponse(userId);
    }

}
