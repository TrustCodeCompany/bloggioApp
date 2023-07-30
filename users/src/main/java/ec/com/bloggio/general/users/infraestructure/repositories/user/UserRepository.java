package ec.com.bloggio.general.users.infraestructure.repositories.user;

import ec.com.bloggio.general.users.domain.entities.User;
import ec.com.bloggio.general.users.domain.interfaces.IUserRepository;
import ec.com.bloggio.general.users.infraestructure.mappers.UserMapper;
import ec.com.bloggio.general.users.infraestructure.repositories.jpa.JpaUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    private final JpaUserRepository jpaUserRepository;

    private final UserMapper mapper;

    public UserRepository(JpaUserRepository jpaUserRepository, UserMapper mapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.mapper = mapper;
    }

    @Override
    public String save(User user){
        return this.jpaUserRepository.save(mapper.toUserModel(user)).getId();
    }

    @Override
    public User login(String email, String pwd){
        var obj = jpaUserRepository.findByEmailAndPwd(email,pwd).map(mapper::toUser);
        return obj.orElse(null);
    }

    @Override
    public User findEmail(String email){
        var obj = jpaUserRepository.findByEmail(email);
        var item = obj.map(mapper::toUser);

        return item.orElse(null);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        var obj = jpaUserRepository.findByEmailAndPwd(email, password).map(mapper::toUser);

        return obj.orElse(null);
    }

    @Override
    public User findId(String id){
        logger.info("findById {} ",id);
        var obj = jpaUserRepository.findById(id).map(mapper::toUser);

        return obj.orElse(null);
    }
    @Override
    public void update(User user) {
        var userModel = mapper.toUserModel(user);
        //Save changes
        jpaUserRepository.save(userModel);
    }

    @Override
    public void updateEnable(Boolean status, String id) {
        jpaUserRepository.updateEnable(status, id);
    }

    @Override
    public List<User> getAll(){
        return  mapper.toUsers(jpaUserRepository.findUsersWithLastName());
    }
}
