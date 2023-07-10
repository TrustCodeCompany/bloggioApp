package ec.com.bloggio.general.bloggio.infraestructure.mappers;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ec.com.bloggio.general.bloggio.domain.entities.User;
import ec.com.bloggio.general.bloggio.infraestructure.model.UserModel;

/**
 * Interface for UserMapper
 * @author trustcode
 * @version 1.0
 */

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "creatorUserId", target = "createUser")
    @Mapping(source = "updaterUserId", target = "updateUser")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "active", target = "isActive")
    User toUSer(UserModel model);

    @InheritInverseConfiguration
    UserModel toUserModel(User user);
}
