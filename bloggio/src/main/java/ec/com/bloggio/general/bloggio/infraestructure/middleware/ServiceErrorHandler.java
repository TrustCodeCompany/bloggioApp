package ec.com.bloggio.general.bloggio.infraestructure.middleware;


import ec.com.bloggio.general.bloggio.controller.models.ErrorMessage;
import ec.com.bloggio.general.bloggio.domain.exceptions.UserNotExistsException;
import ec.com.bloggio.general.bloggio.infraestructure.configuration.MessagesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Entity for ServiceErrorHandler
 * @author trustcode
 * @version 1.0
 */

@ControllerAdvice
@ComponentScan(basePackages = "ec.com.demo.general")
public class ServiceErrorHandler {

    private static final Logger logger_ = LoggerFactory.getLogger(ServiceErrorHandler.class);
    private static final String DEFAULT_VALUE="NULL";

    @Autowired
    MessagesConfig messagesConfig;

    @ExceptionHandler(UserNotExistsException.class)
    public ResponseEntity<Object> handleUserNotExists(UserNotExistsException userNotExistsException, WebRequest request) {
        var message = userNotExistsException.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), HttpStatus.BAD_REQUEST.toString(), message);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
