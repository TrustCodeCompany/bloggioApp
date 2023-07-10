package ec.com.bloggio.general.bloggio.domain.entities;

import lombok.*;

/**
 * Entity for Messages
 * @author trustcode
 * @version 1.0
 */

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Messages {

    private String codeNotFoud;

    private String messageNotFound;

    private String codeOk;

    private String messageOk;

    private String codExistTerms;

    private String messageExistTerms;

    private String codeBadStatus;

    private String messageBadStatus;

    private String codNotExistUserTerm;

    private String messageNotExistUserTerm;

    private String codBadAceptedTermCondition;

    private String messageBadAceptedTermcondition;

    private String codePublished;

    private String messagePublished;

    private String healthApp;

    private String isActiveIntegration;


    private String codExistContentText;


    private String messageExistContentText;

}
