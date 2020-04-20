package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.entity.User;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface UserStorageManager {
    SearchUserResponse searchUser(String term, PageRequest pageRequest);

    SearchUserResponse getUserFriends(String id);

    Optional<User> getUserById(String id);
}
