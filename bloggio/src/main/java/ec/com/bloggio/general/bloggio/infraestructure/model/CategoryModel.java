package ec.com.bloggio.general.bloggio.infraestructure.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Accessors(chain = true)
@Entity
@Table(name = "category")
@Getter
@Setter
public class CategoryModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID categoryId;

    @Column(name = "category_desc", length = 30, nullable = false, unique = false)
    private String categoryDesc;

    @Column(name = "category_state", nullable = false, columnDefinition = "integer default 1")
    private Integer categoryState;

    @Column(name = "category_f_create", updatable = false)
    @CreationTimestamp
    private Timestamp categoryFCreate;

    @Column(name = "category_f_update", insertable = false)
    @UpdateTimestamp
    private Timestamp categoryFUpdate;

    @PrePersist
    public void prePersist(){
        this.categoryState = 1;
    }
}
