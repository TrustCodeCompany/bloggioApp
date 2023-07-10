package ec.com.bloggio.general.bloggio.infraestructure.model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ec.com.bloggio.general.bloggio.infraestructure.model.commons.AbstractBaseAuditable;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity for User
 * @author trustcode
 * @version 1.0
 */

@Accessors(chain = true)
@Entity
@Table(name = "Users")
@Getter
@Setter
public class UserModel extends AbstractBaseAuditable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @PrePersist
    public void prePersist(){
        this.createdAt = new Date(System.currentTimeMillis());
        this.setActive(true);
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = new Date(System.currentTimeMillis());
    }
}
