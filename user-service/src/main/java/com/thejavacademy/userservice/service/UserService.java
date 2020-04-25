package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.UserResponse;
import com.thejavacademy.userservice.model.entity.User;

import java.io.Serializable;

public interface UserService<T extends Serializable> {

//    SearchUserResponse searchUser(String term, int page, int limit);
    SearchUserResponse searchUser(String term);

    SearchUserResponse getFriends(T id);
    User save(User user);

    UserResponse getUser(String id);
    void deleteUser(String id);
}
