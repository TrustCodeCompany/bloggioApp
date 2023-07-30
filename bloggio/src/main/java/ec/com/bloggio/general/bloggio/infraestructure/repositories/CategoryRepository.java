package ec.com.bloggio.general.bloggio.infraestructure.repositories;

import ec.com.bloggio.general.bloggio.domain.entities.Category;
import ec.com.bloggio.general.bloggio.domain.interfaces.ICategoryRepository;
import ec.com.bloggio.general.bloggio.infraestructure.mappers.CategoryMapper;
import ec.com.bloggio.general.bloggio.infraestructure.repositories.jpa.JpaCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryRepository implements ICategoryRepository {

    private final JpaCategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryRepository(JpaCategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public Category findById(String id) {
        return null;
    }

    @Override
    public String save(Category category) {
        var obj = categoryMapper.toCategoryModel(category);
        return categoryRepository.save(obj).getCategoryId().toString();
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(String id) {

    }
}
