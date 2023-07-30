package ec.com.bloggio.general.users.application.command.read;


import ec.com.bloggio.general.authprovider.application.dto.request.partner.LoginPartnerRequest;
import ec.com.bloggio.general.authprovider.infraestructure.configuration.jwt.JwtUtils;
import ec.com.bloggio.general.users.application.dto.response.LoginUserResponse;
import ec.com.bloggio.general.users.domain.entities.User;
import ec.com.bloggio.general.users.domain.interfaces.IUserRepository;
import io.jkratz.mediator.core.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class LoginUserCommandHandler implements RequestHandler<LoginUserCommand, LoginUserResponse> {

    private final IUserRepository userRepository;

    private final JwtUtils jwtUtils;

    public LoginUserCommandHandler(IUserRepository userRepository, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public LoginUserResponse handle(LoginUserCommand loginUserCommand) {
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean verifyPassword;
        User user = userRepository.findEmail(loginUserCommand.getEmail());

        if (null == user) return new LoginUserResponse(null, "user not found");

        LoginPartnerRequest LoginPartnerRequestJWT = new LoginPartnerRequest();
        LoginPartnerRequestJWT.setIdentificationNumber(loginUserCommand.getEmail());

        String jwt = jwtUtils.generateJwtToken(LoginPartnerRequestJWT);

        user.setJwt(jwt);

        verifyPassword = bCryptPasswordEncoder.matches(loginUserCommand.getPwd(),user.getPwd());

        if (user.getEnabled() && verifyPassword) {
            return new LoginUserResponse(user,"ok");
        } else if (user.getEnabled() && !verifyPassword) {
            return new LoginUserResponse(null, "password incorrect");
        } else {
            User disabledUser = new User();
            disabledUser.setEnabled(false);
            return new LoginUserResponse(disabledUser,"user disabled");
        }

    }
}