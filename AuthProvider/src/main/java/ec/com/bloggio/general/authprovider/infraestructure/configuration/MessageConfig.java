package ec.com.bloggio.general.authprovider.infraestructure.configuration;

import ec.com.bloggio.general.authprovider.domain.entities.Messages;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
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
