package ec.com.bloggio.general.bloggio.domain.exceptions;

/**
 * Entity for Exception UserNotExists
 * @author trustcode
 * @version 1.0
 */

 public class UserNotExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserNotExistsException(String message) {
        super(message);
    }
}
