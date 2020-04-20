package com.thejavacademy.userservice.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchUserResponse {

    private List<SearchedUser> users = new ArrayList<>();

}
