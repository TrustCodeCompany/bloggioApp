package ec.com.bloggio.general.users.domain.interfaces;


import ec.com.bloggio.general.users.domain.entities.User;

import java.util.List;

public interface IUserRepository {
    String save(User user);
    User findEmail(String email);
    User findByEmailAndPassword(String email, String password);
    User findId(String id);
    User login(String email, String pwd);
    void update(User user);
    void updateEnable(Boolean status, String id);
    List<User> getAll();
}
