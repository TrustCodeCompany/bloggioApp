package ec.com.bloggio.general.bloggio.infraestructure.model.commons;

import lombok.Builder;
import lombok.Getter;


/**
 * Vo for response api
 *
 * @author trustcode
 * @version 1.0
 * @param <T> Type data response
 */

@Builder
@Getter
public class Response<T> {
    /**
     * Data to response
     */
    private T bodyOut;

    /**
     * Message to response
     */
    private String message;

    /**
     * Code to response
     */
    private Integer code;
}
