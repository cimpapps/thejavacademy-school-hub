package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.UserResponse;

public interface UserService {

    SearchUserResponse searchUser(String term, int page, int limit);

    SearchUserResponse getFriends(String id);

    UserResponse getUser(String id);
}
