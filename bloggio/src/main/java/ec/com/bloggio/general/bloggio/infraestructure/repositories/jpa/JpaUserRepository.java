package ec.com.bloggio.general.bloggio.infraestructure.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.bloggio.general.bloggio.infraestructure.model.UserModel;

import java.util.Optional;

/**
 * Interface for UserRepository
 * @author trustcode
 * @version 1.0
 */

public interface JpaUserRepository extends JpaRepository<UserModel, Long> {
    
    Optional<UserModel> findById(long id);

}
