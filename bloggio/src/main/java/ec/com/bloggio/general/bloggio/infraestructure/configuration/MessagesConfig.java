package ec.com.bloggio.general.bloggio.infraestructure.configuration;

import ec.com.bloggio.general.bloggio.domain.entities.Messages;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Entity for MessagesConfig
 * @author trustcode
 * @version 1.0
 */

 @Configuration
public class MessagesConfig {

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
    private String codBadAceptedTermCondition;

    @Value("${messages.messagebadtermcondition}")
    private String messageBadAceptedTermcondition;

    @Value("${messages.messagecodeexistpublishitem}")
    private String codExistPublishItem;

    @Value("${messages.messageexistpublishitem}")
    private String messageExistPublishItem;

    @Value("${messages.healthapp}")
    private String healthApp;

    @Value("${messages.isactiveintegration}")
    private String isActiveIntegration;

    @Value("${messages.messagecodeexistcontent}")
    private String codExistContentText;

    @Value("${messages.messageexistcontent}")
    private String messageExistContentText;




    @Bean
    public Messages getMessages(){
        return new Messages(codeNotFound,messageNotFound,codeOk,messageOk,
                codExistTerms,messageExistTerms,codeBadStatus,messageBadStatus,codNotExistUserTerm,messageNotExistUserTerm,
                codBadAceptedTermCondition,messageBadAceptedTermcondition,codExistPublishItem,messageExistPublishItem, healthApp,
                isActiveIntegration,codExistContentText,messageExistContentText);
    }

}