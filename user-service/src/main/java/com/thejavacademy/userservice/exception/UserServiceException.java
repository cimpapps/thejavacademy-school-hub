package com.thejavacademy.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserServiceException extends RuntimeException {

    private ExceptionType type;

    public enum ExceptionType {
        USER_NOT_FOUND(1, "User not found"),
        SERVER_ERROR(500, "something went wrong"),
        EMTPY_USER_ID(400, "the ID is mandatory"),
        ;

        int code;
        String message;

        ExceptionType(int code, String message){
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }


}
