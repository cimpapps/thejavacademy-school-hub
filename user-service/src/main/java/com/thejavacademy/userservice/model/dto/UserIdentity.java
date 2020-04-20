package com.thejavacademy.userservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserIdentity {

    @JsonProperty(required = true)
    private String id;
    @JsonProperty(required = true)
    private String username;
    @JsonProperty(required = true)
    private String lastName;
    private String firstName;
    private String profilePicture;

}
