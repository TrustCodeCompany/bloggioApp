package ec.com.bloggio.general.authprovider.domain.exceptions;



public class UserExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserExistsException(String message, String identificationNumber) {
        super(message + identificationNumber);
    }
}
