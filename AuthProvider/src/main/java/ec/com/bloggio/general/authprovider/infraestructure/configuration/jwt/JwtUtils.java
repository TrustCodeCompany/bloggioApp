package ec.com.bloggio.general.authprovider.infraestructure.configuration.jwt;

import ec.com.bloggio.general.authprovider.application.dto.request.partner.LoginPartnerRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationDateInMs}")
    private int jwtExpirationMs;


    @Value("${general.config.constans.authorities}")
    public String AUTHORITIES ;

    @Value("${general.config.constans.id}")
    public String ID = "mundosAPIJWT";


    @Value("${general.config.constans.headersJWTPartnerLoginID}")
    public String headersJWTPartnerLoginID;

    @Value("${general.config.constans.headersJWTPartnerLoginDevice}")
    public String headersJWTPartnerLoginDevice;

    @Value("${general.config.constans.headersJWTPartnerLoginType}")
    public String headersJWTPartnerLoginType;

    public String generateJwtToken(LoginPartnerRequest data) {

        Map<String, Object> headers = new HashMap<>();
        headers.put(headersJWTPartnerLoginID, data.getIdentificationNumber());
        headers.put(headersJWTPartnerLoginDevice, data.getIdentificationDevice());
        headers.put(headersJWTPartnerLoginType, data.getIdentificationType());

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN,ROLE_ADMIN,PARTNER,ROLE_PARTNER");

        String token = Jwts.builder().setId(ID).setSubject(data.getIdentificationNumber())
                .setHeaderParams(headers)
                .claim(AUTHORITIES,grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

        return token;
    }
}
