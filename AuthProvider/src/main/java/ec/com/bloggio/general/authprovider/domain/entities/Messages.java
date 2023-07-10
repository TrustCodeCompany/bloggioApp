package ec.com.bloggio.general.authprovider.domain.entities;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Messages {

    private String codeNotFound;

    private String messageNotFound;

    private String codeOk;

    private String messageOk;

    private String codExistTerms;

    private String messageExistTerms;

    private String codeBadStatus;

    private String messageBadStatus;

    private String codNotExistUserTerm;

    private String messageNotExistUserTerm;

    private String codBadAcceptedTermCondition;

    private String messageBadAcceptedTermCondition;
}