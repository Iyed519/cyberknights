package tn.coconsultbackend.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum BusinessErrorCodes {
    NO_CODE(0,HttpStatus.NOT_IMPLEMENTED,"NO CODE"),
    INCORRECT_CURRENT_PASSWORD(300,HttpStatus.BAD_REQUEST,"INCORRECT PASSWORD"),
    NEW_PASSWORD_DOES_NOT_MUCH(301,HttpStatus.BAD_REQUEST,"NEW PASSWORD DOES NOT MAY MATCH"),
    ACCOUNT_LOCKED(302,HttpStatus.FORBIDDEN,"ACCOUNT LOCKED"),
    ACCOUNT_DISABLED(303,HttpStatus.FORBIDDEN,"ACCOUNT DISABLED"),
    BAD_CREDENTIALS(303,HttpStatus.BAD_REQUEST,"EMAIL OR PASSWORD INCORRECT"),
    ;

    @Getter
    private final int code;

    @Getter
    private final String description;

    @Getter
    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }
}

