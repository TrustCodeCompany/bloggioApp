package ec.com.bloggio.general.bloggio.application.command.create;

import ec.com.bloggio.general.bloggio.application.dto.response.CreateCategoryResponse;
import ec.com.bloggio.general.bloggio.domain.entities.Category;
import ec.com.bloggio.general.bloggio.domain.interfaces.ICategoryRepository;
import io.jkratz.mediator.core.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Slf4j
public class CreateCategoryCommandHandler implements RequestHandler<CreateCategoryCommand, CreateCategoryResponse> {

    private final ICategoryRepository categoryRepository;

    public CreateCategoryCommandHandler(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public CreateCategoryResponse handle(CreateCategoryCommand createCategoryCommand) {
        String categoryId = "";
        Category category = new Category();
        category.setCategoryDesc(createCategoryCommand.getName());
        categoryId = categoryRepository.save(category);
        return new CreateCategoryResponse(categoryId);
    }
}
