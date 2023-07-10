package ec.com.bloggio.general.bloggio.application.queries;

import ec.com.bloggio.general.bloggio.domain.entities.User;
import ec.com.bloggio.general.bloggio.domain.interfaces.IUserRepository;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Entity for Query GetUSerHandler
 * @author trustcode
 * @version 1.0
 */


@Component
public class GetUserQueryHandler implements RequestHandler<GetUserQuery, List<User>> {
    private final IUserRepository userRepository;

    @Autowired
    private Mediator mediator;

    public GetUserQueryHandler(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetUserQuery getUserQuery) {
        return userRepository.getAll();
    }


}
