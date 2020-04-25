package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.entity.Friendship;
import com.thejavacademy.userservice.model.entity.User;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.Optional;

public interface UserStorageAdapter<T extends Serializable> {
//    SearchUserResponse searchUser(String term, PageRequest pageRequest);
    SearchUserResponse searchUser(String term);

    SearchUserResponse getUserFriends(T idOne);

    Optional<User> getUserById(T id);

    User save(User user);

    void deleteUser(String id);

    Friendship getRelationship(String userOneId, String userTwoId);
    boolean areTheyFriends(String userOneId, String userTwoId);
    boolean areTheyInARelationship(String userOneId, String userTwoId);


}
