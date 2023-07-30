package ec.com.bloggio.general.bloggio.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateCategoryRequest {

    @NotBlank(message = "campo nombre es requerido.")
    private String name;
}
