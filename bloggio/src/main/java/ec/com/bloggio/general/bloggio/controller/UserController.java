package ec.com.bloggio.general.bloggio.controller;

import ec.com.bloggio.general.bloggio.application.command.create.CreateUserCommand;
import ec.com.bloggio.general.bloggio.application.command.update.UpdateUserCommand;
import ec.com.bloggio.general.bloggio.application.dto.response.CreateUserResponse;
import ec.com.bloggio.general.bloggio.application.dto.response.UpdateUserResponse;
import ec.com.bloggio.general.bloggio.application.queries.GetUserQuery;
import ec.com.bloggio.general.bloggio.application.queries.user.GetUserByIdQuery;
import ec.com.bloggio.general.bloggio.domain.entities.User;
import ec.com.bloggio.general.bloggio.infraestructure.model.commons.Response;
import ec.com.bloggio.general.bloggio.application.queries.user.DeleteUserByIdQuery;
import io.jkratz.mediator.core.Mediator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    public static final String SENDING_COMMAND = "------ Sending command : {} {} ";
    public static final String SENDING_QUERY = "------ Sending query in {}: {} {}";


    @Value("${general.config.constans.SUCCESS}")
    public String SUCCESS ;

    @Value("${general.config.constans.OK}")
    public int OK ;

    private final Mediator mediator;

    public UserController(Mediator mediator){
        this.mediator = mediator;
    }

    /**
     * Metodo que registra un usuario en la bd
     * @param command
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Response<CreateUserResponse>> createUser(@Valid @RequestBody CreateUserCommand command) {
            logger.info(SENDING_COMMAND, command.getClass().getName(), command);
        return new ResponseEntity<>(Response.<CreateUserResponse>builder()
                .bodyOut(this.mediator.dispatch(command))
                .code(OK).message(SUCCESS).build(), HttpStatus.OK);
    }

    /***
     * Metodo que obtiene todos los usuarios
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<Response<List<User>>> getUser() {
            var query = new GetUserQuery();
            var listUser = this.mediator.dispatch(query);
            return new ResponseEntity<>(Response.<List<User>>builder().bodyOut(listUser)
                    .code(OK).message(SUCCESS).build(), HttpStatus.OK);
    }

    /**
     * Metodo que obtiene usuario por id
     * @param id
     * @return User
     */
    @GetMapping("/get/ById/{id}")
    public ResponseEntity<Response<User>> getUserById(@NotBlank @PathVariable("id") Long id) {
        logger.info("Get User Controller");
        var query = new GetUserByIdQuery();
        query.setUserId(id);
        return new ResponseEntity<>(Response.<User>builder().bodyOut(this.mediator.dispatch(query))
                .code(OK).message(SUCCESS).build(), HttpStatus.OK);
    }

    /**
     * Metodo: api que actualiza el usuario
     * @param command
     * @return UpdateUserResponse
     */
    @PutMapping("/update")
    public ResponseEntity<Response<UpdateUserResponse>> updateEstablishment(@Valid @RequestBody UpdateUserCommand command) {
        logger.info(SENDING_COMMAND, command.getClass().getName(), command);
        return new ResponseEntity<>(Response.<UpdateUserResponse>builder()
                .bodyOut(this.mediator.dispatch(command))
                .code(OK).message(SUCCESS).build(), HttpStatus.OK);
    }


    /**
     * Metodo que elimina un usuario por id
     * @param id
     * @return void
     */
    @GetMapping("/delete/ById/{id}")
    public ResponseEntity<Response<User>> deleteUserById(@NotBlank @PathVariable("id") Long id) {
        logger.info("Delete User Controller");
        var query = new DeleteUserByIdQuery();
        query.setUserId(id);
        return new ResponseEntity<>(Response.<User>builder().bodyOut(this.mediator.dispatch(query))
                .code(OK).message(SUCCESS).build(), HttpStatus.OK);
    }
    
}
