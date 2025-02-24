package tn.coconsultbackend.email;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum EmailTemplateName {
    ACTIVATE_ACCOUNT("activate_Account")


    ;

    private final String name;

    EmailTemplateName(String name) {
        this.name = name;
    }
}
