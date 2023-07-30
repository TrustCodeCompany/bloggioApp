package ec.com.bloggio.general.users.api.controllers.users;


import ec.com.bloggio.general.users.application.command.create.CreateUserCommand;
import ec.com.bloggio.general.users.application.command.read.LoginUserCommand;
import ec.com.bloggio.general.users.application.dto.response.CreateUserResponse;
import ec.com.bloggio.general.users.application.dto.response.LoginUserResponse;
import io.jkratz.mediator.core.Mediator;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/general")
public class UsersController {
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
    public static final String SENDING_COMMAND = "------ Sending command: {} {}";
    public static final String SENDING_QUERY = "------ Sending query: {} {}";
    private final Mediator mediator;

    @Autowired
    public UsersController(Mediator mediator) {
        this.mediator = mediator;
    }
    @PostMapping("/createUser")
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserCommand command) {
        try {
            CreateUserCommand safeCommand = new CreateUserCommand();
            safeCommand.setEmail(command.getEmail());
            safeCommand.setLastName(sanitizeString(command.getLastName()));
            safeCommand.setName(sanitizeString(command.getName()));
            safeCommand.setPassword(sanitizeString(command.getPassword()));
            safeCommand.setPhoto(sanitizeString(command.getPhoto()));
            logger.info(SENDING_COMMAND, command.getClass().getName(), command);
            return new ResponseEntity<>(this.mediator.dispatch(safeCommand), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            logger.error(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/loginUser")
    public ResponseEntity<LoginUserResponse> loginUser(@Valid @RequestBody LoginUserCommand command) {
        try {
            LoginUserCommand safeCommand = new LoginUserCommand();
            safeCommand.setEmail(command.getEmail());
            safeCommand.setPwd(command.getPwd());
            logger.info(SENDING_COMMAND, command.getClass().getName(), command);
            return new ResponseEntity<>(this.mediator.dispatch(safeCommand), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            logger.error(e.getReason() + ", message: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public String sanitizeString(String value){
        PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        String safeValue= policy.sanitize( value );
        logger.info("safeParameterId {}", safeValue);
        return safeValue;
    }

}
