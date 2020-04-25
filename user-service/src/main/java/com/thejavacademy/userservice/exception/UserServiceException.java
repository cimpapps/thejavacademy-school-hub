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
        EMPTY_USER_ID(400, "the ID is mandatory"),
        FRIENDSHIP_EXISTS(409, "friendship already exists"),
        FRIENDSHIP_DOES_NOT_EXISTS(409, "doesn't exists");

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
