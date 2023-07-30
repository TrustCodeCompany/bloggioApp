package ec.com.bloggio.general.authprovider.infraestructure.middleware;

import ec.com.bloggio.general.authprovider.domain.entities.ErrorMessage;
import ec.com.bloggio.general.authprovider.domain.exceptions.DomainException;
import ec.com.bloggio.general.authprovider.domain.exceptions.UserExistsException;
import ec.com.bloggio.general.authprovider.infraestructure.configuration.MessageConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.NoSuchElementException;

@ControllerAdvice
@ComponentScan(basePackages = "ec.com.bloggio.general")
public class ServiceErrorHandlerAuth {

    private static final Logger logger_ = LoggerFactory.getLogger(ServiceErrorHandlerAuth.class);
    private static final String DEFAULT_VALUE="NULL";

    @Autowired
    MessageConfig messagesConfig;


    public ServiceErrorHandlerAuth(MessageConfig messagesConfig) {
        this.messagesConfig = messagesConfig;
    }

    @ExceptionHandler(DomainException.class)
    public final ResponseEntity<Object> handleFilesDomainException(DomainException ex, WebRequest request) {

        var internalMessage = ex.getInternalMessage();

        logger_.warn("Error.:", internalMessage != null && Boolean.FALSE.equals(internalMessage.isEmpty())
                ? ex.getInternalMessage()
                : ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(new Date(),ex.getHttpStatus().toString(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), ex.getHttpStatus());
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Object> noSuchElementException(NoSuchElementException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), HttpStatus.NOT_FOUND.toString(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = {ClassNotFoundException.class})
    public ResponseEntity<Object> classNotFoundException(ClassNotFoundException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(),HttpStatus.NOT_FOUND.toString(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }




    @ExceptionHandler(value = {IllegalStateException.class})
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(),HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleIllegalAccesException(BadCredentialsException badCredentialsException, WebRequest request) {
        var message = "Credenciales incorrectas";
        ErrorMessage errorMessage = new ErrorMessage(new Date(),HttpStatus.UNAUTHORIZED.toString(), message);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<Object> handleInvalidCIException(UserExistsException userExistsException, WebRequest request) {
        var message = userExistsException.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(new Date(),HttpStatus.BAD_REQUEST.toString(), message);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        var message = "Validación fallida";
        ErrorMessage errorMessage = new ErrorMessage(new Date(),HttpStatus.BAD_REQUEST.toString(), message);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
        var message = "Está acción ha vulnerado una restricción de integridad de los datos. Por favor, contactarse con el Administrador del Sistema.";
        logger_.error("Error.:", ex);
        ErrorMessage errorMessage = new ErrorMessage(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), message);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        logger_.info("Error.: {}", ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
