package ec.com.bloggio.general.bloggio.controller;

import ec.com.bloggio.general.bloggio.application.command.create.CreateCategoryCommand;
import ec.com.bloggio.general.bloggio.application.dto.response.CreateCategoryResponse;
import ec.com.bloggio.general.bloggio.infraestructure.model.commons.Response;
import io.jkratz.mediator.core.Mediator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final Mediator mediator;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    public static final String SENDING_COMMAND = "------ Sending command : {} {} ";

    @Value("${general.config.constans.SUCCESS}")
    public String SUCCESS ;

    @Value("${general.config.constans.OK}")
    public int OK ;


    public CategoryController(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * Metodo que registra un usuario en la bd
     * @param command
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Response<CreateCategoryResponse>> createCategory(@Valid @RequestBody CreateCategoryCommand command) {
        logger.info(SENDING_COMMAND, command.getClass().getName(), command);
        return new ResponseEntity<>(Response.<CreateCategoryResponse>builder()
                .bodyOut(this.mediator.dispatch(command))
                .code(OK).message(SUCCESS).build(), HttpStatus.OK);
    }
}
