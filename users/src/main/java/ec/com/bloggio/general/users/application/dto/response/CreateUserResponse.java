package ec.com.bloggio.general.users.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponse {
    private String userId;

    public CreateUserResponse(String userId) {
        this.userId = userId;
    }
}
