package ec.com.bloggio.general.authprovider.infraestructure.configuration;

import ec.com.bloggio.general.authprovider.domain.entities.Messages;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${messages.codenotfound}")
    private String codeNotFound;

    @Value("${messages.messagenotfoud}")
    private String messageNotFound;

    @Value("${messages.codeok}")
    private String codeOk;

    @Value("${messages.messageok}")
    private String messageOk;

    @Value("${messages.codduplicateversion}")
    private String codExistTerms;

    @Value("${messages.messageduplicaversion}")
    private String messageExistTerms;

    @Value("${messages.codduplicatestate}")
    private String codeBadStatus;

    @Value("${messages.messageduplicatestate}")
    private String messageBadStatus;

    @Value("${messages.codnotexistuserterm}")
    private String codNotExistUserTerm;

    @Value("${messages.messagenotexistuserterm}")
    private String messageNotExistUserTerm;

    @Value("${messages.codbadaceptedtermcondition}")
    private String codBadAcceptedTermCondition;

    @Value("${messages.messagebadtermcondition}")
    private String messageBadAcceptedTermCondition;

    @Bean
    public Messages getMessagesAuth(){
        return new Messages(codeNotFound,messageNotFound,codeOk,messageOk,
                codExistTerms,messageExistTerms,codeBadStatus,messageBadStatus,codNotExistUserTerm,messageNotExistUserTerm,
                codBadAcceptedTermCondition,messageBadAcceptedTermCondition);
    }
}
