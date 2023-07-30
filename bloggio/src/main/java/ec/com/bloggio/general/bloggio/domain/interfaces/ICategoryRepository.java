package ec.com.bloggio.general.bloggio.domain.interfaces;

import ec.com.bloggio.general.bloggio.domain.entities.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> getAll();
    Category findById(String id);
    String save(Category category);

    void update(Category category);
    void delete(String id);
}
