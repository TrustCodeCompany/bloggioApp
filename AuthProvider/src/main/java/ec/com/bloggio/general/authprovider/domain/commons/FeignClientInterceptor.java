package ec.com.bloggio.general.authprovider.domain.commons;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(FeignClientInterceptor.class);

    @Value("${general.config.apiKeyHeader}")
    private String apiKeyHeader;

    private static final String AUTHORIZATION_HEADER="Authorization";
    private static final String API_KEY_HEADER="x-api-key";
    private static final String TOKEN_TYPE = "Bearer";

    private String jwtToken;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        logger.info("JWT from add to header {}", jwtToken);

        logger.info("apiKeyHeader from add to header {}", apiKeyHeader);

        if (!Objects.equals(jwtToken, "")){
            requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, jwtToken));
        }
        requestTemplate.header(API_KEY_HEADER, String.format("%s", apiKeyHeader));
    }

    public void setjwtToken(String jwtToken){
        this.jwtToken=jwtToken;
    }

}