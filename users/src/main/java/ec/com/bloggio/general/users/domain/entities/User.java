package ec.com.bloggio.general.users.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class User {
    private String userId;
    private String name;
    private String lastName;
    private String photo;
    private String email;
    private String pwd;
    private Boolean enabled;
    private Date createdAt;
    private String jwt;

}
