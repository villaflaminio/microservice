package com.flaminiovilla.bookshare.exception;

public class BasicException extends RuntimeException{
    public enum basicExceptionCode{
        CATEGORY_NOT_EXIST,
        SECRETARY_NOT_EXIST,
        REFERRAL_PERSON_NOT_EXIST,
        LATITUDE_AND_LONGITUDE_ALREADY_EXISTING,
        EXPIRE_DATA_CONVENTION_WRONG,
        ILLEGAL_ARGUMENT,
        MACRO_CATEGORY_NOT_FOUND,
        STRUCTURE_DELETE_ERROR,
        STRUCTURE_ID_NOT_EXIST
        }

    public BasicException(basicExceptionCode message) {
        super(message.toString());
    }
}
