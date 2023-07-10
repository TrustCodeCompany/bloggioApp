package ec.com.bloggio.general.bloggio.domain.entities;


import lombok.Getter;
import lombok.Setter;

/**
 * Entity for User
 * @author trustcode
 * @version 1.0
 */

@Getter
@Setter
public class User {

    private long id;
    private String name;
    private String createUser;
    private String updateUser;
    private String createdAt;
    private Boolean isActive;
    
}
