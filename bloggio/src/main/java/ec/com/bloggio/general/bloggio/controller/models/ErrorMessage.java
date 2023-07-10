package ec.com.bloggio.general.bloggio.controller.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Entity for ErrorMessage
 * @author trustcode
 * @version 1.0
 */

@Data
@AllArgsConstructor
public class ErrorMessage {
    private final Date timestamp;
    private final String code;
    private final String message;
}