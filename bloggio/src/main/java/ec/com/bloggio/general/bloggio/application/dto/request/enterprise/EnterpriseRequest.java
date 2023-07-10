package ec.com.bloggio.general.bloggio.application.dto.request.enterprise;



import lombok.Getter;
import lombok.Setter;
import ec.com.bloggio.general.bloggio.application.dto.request.user.UserRequest;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class EnterpriseRequest {
    
    private Long countryId;
    @NotBlank(message = "businessName field can't be empty.")
    private String businessName;
    @NotBlank(message = "identificationNumber field can't be empty.")
    private String identificationNumber;
    private String creatorUserId;
    private List<UserRequest> users;

}
