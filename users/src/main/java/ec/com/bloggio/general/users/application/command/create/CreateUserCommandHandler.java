package ec.com.bloggio.general.users.application.command.create;


import ec.com.bloggio.general.users.application.dto.response.CreateUserResponse;
import ec.com.bloggio.general.users.domain.entities.User;
import ec.com.bloggio.general.users.domain.interfaces.IUserRepository;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CreateUserCommandHandler implements RequestHandler<CreateUserCommand, CreateUserResponse> {

    private final IUserRepository userRepository;

    public CreateUserCommandHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse handle(CreateUserCommand createStoreCommand) {

        var user = new User();
        user.setName(createStoreCommand.getName());
        user.setLastName(createStoreCommand.getLastName());
        user.setEmail(createStoreCommand.getEmail());
        user.setPhoto(createStoreCommand.getPhoto());
        user.setPwd(encryptionPassword(createStoreCommand.getPassword()));
        String userId = userRepository.save(user);
        return new CreateUserResponse(userId);
    }
    public String encryptionPassword(String passwordActual) {
        PasswordEncoder bCryptPasswordEncoder;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(passwordActual);
    }
}
