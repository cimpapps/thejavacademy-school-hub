package com.thejavacademy.userservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SearchedUser {

    private UserIdentity userIdentity;
    private String profilePicture;

}
