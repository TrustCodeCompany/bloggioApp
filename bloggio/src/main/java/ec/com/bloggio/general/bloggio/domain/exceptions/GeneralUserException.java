package ec.com.bloggio.general.bloggio.domain.exceptions;

/**
 * Entity for GeneralUserException
 * @author trustcode
 * @version 1.0
 */

public class GeneralUserException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public GeneralUserException(String code, String message){
        super(code+"#"+message);
    }
    
}
