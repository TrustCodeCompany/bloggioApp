package ec.com.bloggio.general.bloggio.application.command.create;

import ec.com.bloggio.general.bloggio.application.dto.request.CreateCategoryRequest;
import ec.com.bloggio.general.bloggio.application.dto.response.CreateCategoryResponse;
import io.jkratz.mediator.core.Request;

public class CreateCategoryCommand extends CreateCategoryRequest implements Request<CreateCategoryResponse> {

    public CreateCategoryCommand() {
        super();
    }
}
