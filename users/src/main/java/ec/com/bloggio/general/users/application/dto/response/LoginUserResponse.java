package ec.com.bloggio.general.users.application.dto.response;


import ec.com.bloggio.general.users.domain.entities.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginUserResponse {
    private User user;
    private String message;
    public LoginUserResponse(User user, String message){
        this.user = user;
        this.message = message;
    }
    public LoginUserResponse(){

    }
}
