package com.flaminiovilla.bookshare.security.exception;

public class UserException extends RuntimeException{

    public enum userExceptionCode{
        PARAMETER_NULL,
        EMAIL_NOT_EXIST,
        USER_ALREADY_EXISTS,
        AUTHORITY_NOT_EXIST
    }
    public UserException(userExceptionCode message) {
        super(message.toString());
    }

}
