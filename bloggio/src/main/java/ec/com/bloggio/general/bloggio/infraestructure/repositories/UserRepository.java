package ec.com.bloggio.general.bloggio.infraestructure.repositories;

import java.util.List;
import java.util.stream.Collectors;

import ec.com.bloggio.general.bloggio.domain.entities.User;
import ec.com.bloggio.general.bloggio.domain.interfaces.IUserRepository;
import ec.com.bloggio.general.bloggio.infraestructure.mappers.UserMapper;
import ec.com.bloggio.general.bloggio.infraestructure.repositories.jpa.JpaUserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Entity for UserRepository
 * @author trustcode
 * @version 1.0
 */


@Repository
public class UserRepository implements IUserRepository {

    public static final String SENDING_COMMAND = "------ Sending command: {} {}";
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    private final JpaUserRepository jpaUserRepository;

    private final UserMapper userMapper;

    public UserRepository(JpaUserRepository jpaUserRepository, UserMapper userMapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAll() {
        return jpaUserRepository.findAll().stream()
                .map(userModel -> userMapper.toUSer(userModel))
                .collect(Collectors.toList());
    }

    @Override
    public User findById(long id) {
        var obj = jpaUserRepository.findById(id).map(model -> userMapper.toUSer(model));

        if(obj.isPresent()){
            return obj.get();
        }
        return null;
    }

    @Override
    public long save(User user) {
        var userModel = userMapper.toUserModel(user);
        return jpaUserRepository.save(userModel).getId();
    }

    @Override
    public void update(User user) {
        var userModel = userMapper.toUserModel(user);
        jpaUserRepository.save(userModel);
    }

    @Override
    public void delete(long id) {
        User u = findById(id);
        if (u != null){
            jpaUserRepository.deleteById(id);
        }
    }
    
}
