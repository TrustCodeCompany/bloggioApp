package ec.com.bloggio.general.bloggio.infraestructure.mappers;


import ec.com.bloggio.general.bloggio.domain.entities.Category;
import ec.com.bloggio.general.bloggio.infraestructure.model.CategoryModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "categoryId", target = "categoryId")
    @Mapping(source = "categoryDesc", target = "categoryDesc")
    @Mapping(source = "categoryState", target = "categoryState")
    Category toCategory(CategoryModel categoryModel);

    @InheritInverseConfiguration
    CategoryModel toCategoryModel(Category category);

}
