package ec.com.bloggio.general.bloggio.application.dto.request.enterprise;

import javax.validation.constraints.NotBlank;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import ec.com.bloggio.general.bloggio.application.dto.request.user.UserUpdateRequest;

@Getter
@Setter
public class EnterpriseUpdateRequest {
    private Long countryId;
    @NotBlank(message = "businessName field can't be empty.")
    private String businessName;
    @NotBlank(message = "identificationNumber field can't be empty.")
    private String identificationNumber;
    private String creatorUserId;
    private List<UserUpdateRequest> users;

}
