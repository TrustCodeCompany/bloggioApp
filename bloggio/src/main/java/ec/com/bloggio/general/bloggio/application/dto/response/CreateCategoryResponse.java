package ec.com.bloggio.general.bloggio.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryResponse {

    private String id;

    public CreateCategoryResponse(String id) {
        this.id = id;
    }
}
