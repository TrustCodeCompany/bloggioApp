package ec.com.bloggio.general.users.infraestructure.mappers;


import ec.com.bloggio.general.users.domain.entities.User;
import ec.com.bloggio.general.users.infraestructure.model.UserModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source="id", target="userId")
    @Mapping(source="name", target="name")
    @Mapping(source="lastName", target="lastName")
    @Mapping(source="email", target="email")
    @Mapping(source="pwd", target="pwd")
    @Mapping(source="enabled", target="enabled")
    @Mapping(source="createdAt", target="createdAt")
    User toUser(UserModel model);

    List<User> toUsers(List<UserModel> userModels);

    @InheritInverseConfiguration
    UserModel toUserModel(User user);
}
