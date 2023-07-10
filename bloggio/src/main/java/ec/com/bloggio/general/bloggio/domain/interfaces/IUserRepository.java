package ec.com.bloggio.general.bloggio.domain.interfaces;

import ec.com.bloggio.general.bloggio.domain.entities.User;

import java.util.List;

/**
 * Interface for UserRepository
 * @author trustcode
 * @version 1.0
 */

public interface IUserRepository {

    List<User> getAll();
    User findById(long id);
    long save(User store);
    void update(User user);
    void delete(long id);
    
}
