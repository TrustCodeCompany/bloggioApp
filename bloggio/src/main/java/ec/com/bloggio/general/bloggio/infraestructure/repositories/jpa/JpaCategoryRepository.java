package ec.com.bloggio.general.bloggio.infraestructure.repositories.jpa;

import ec.com.bloggio.general.bloggio.infraestructure.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaCategoryRepository extends JpaRepository<CategoryModel, UUID> {
    Optional<CategoryModel> findByCategoryDesc(String categoryDesc);
}
