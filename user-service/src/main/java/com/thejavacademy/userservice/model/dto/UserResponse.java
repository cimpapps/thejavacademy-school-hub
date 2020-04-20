package com.thejavacademy.userservice.model.dto;

import lombok.Data;

@Data
public class UserResponse {

    private UserIdentity userIdentity;
    private String profilePicture;
    private UserContact userContact;
}
