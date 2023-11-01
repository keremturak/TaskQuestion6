package com.keremturak.exception;

import lombok.Getter;

@Getter
public class MyCompanyException extends RuntimeException{
    private final EErrorType EErrorType;

    public MyCompanyException(EErrorType EErrorType){
        super(EErrorType.getMessage());
        this.EErrorType = EErrorType;
    }

    public MyCompanyException(EErrorType EErrorType, String message){
        super(message);
        this.EErrorType = EErrorType;
    }
}
