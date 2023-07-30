package ec.com.bloggio.general.bloggio.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class Category {

    private UUID categoryId;

    private String categoryDesc;

    private Integer categoryState;

}
