package com.keremturak.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EErrorType {



    INTERNAL_ERROR(3000,"Unexpected error on server",INTERNAL_SERVER_ERROR),
    INVALID_TOKEN(4001,"Invalid token information",BAD_REQUEST),
    BAD_REQUEST_ERROR(1202,"You have entered an invalid parameter",BAD_REQUEST),

    COMPANY_NOT_BE_FOUND(2302,"The company you were looking for could not be found",BAD_REQUEST),
    EMPLOYEE_NOT_BE_FOUND(2303,"The employee you were looking for could not be found",BAD_REQUEST),
    EMPLOYEE_NAME_NOT_FOUND(2303,"The employee name you were looking for could not be found",BAD_REQUEST),
    DTO_IS_NULL(2303,"The DTO you were looking for could not be found",BAD_REQUEST),
    USER_NOT_IN_COMPANY(2307,"The user you were looking for could not be found that company",BAD_REQUEST);
    private int code;
    private String message;
    private HttpStatus httpStatus;
}
