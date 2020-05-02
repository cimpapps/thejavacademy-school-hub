package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.SearchedUser;
import com.thejavacademy.userservice.model.dto.UserIdentity;
import com.thejavacademy.userservice.model.entity.Friendship;
import com.thejavacademy.userservice.model.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface UserStorageAdapter {
    SearchUserResponse searchUser(String term);

    SearchUserResponse getUserFriends(String idOne);

    Optional<User> getUserById(String id);

    User save(User user);

    void deleteUser(String id);

    List<UserIdentity> getUsers();
}
