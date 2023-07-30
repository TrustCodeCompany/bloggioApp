package ec.com.bloggio.general.users.infraestructure.repositories.jpa;


import ec.com.bloggio.general.users.infraestructure.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmailAndPwd(String email, String pwd);
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findById(String id);
    @Modifying
    @Query(value = "UPDATE users SET enabled = :status WHERE id LIKE :id",
            nativeQuery = true)
    void updateEnable(@Param("status") Boolean status, @Param("id") String id);

    @Query(value = "SELECT * FROM users WHERE last_name IS NOT NULL OR last_name != '' ", nativeQuery = true)
    List<UserModel> findUsersWithLastName();
}
