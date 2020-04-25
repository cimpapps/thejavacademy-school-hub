package com.thejavacademy.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FriendshipServiceException extends RuntimeException {
    private ExceptionType type;

    public enum ExceptionType {

        FRIENDSHIP_NOT_FOUND(5171, "Friendship not found"),
        SERVER_ERROR(500, "something went wrong"),
        EMPTY_ID(400, "the ID is mandatory"),
        NULL_INSTANCE(5172,"Friendship object is null")
        ;

        private int code;
        private String message;

        ExceptionType(int code, String message) {
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
