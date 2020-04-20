package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.UserResponse;
import com.thejavacademy.userservice.model.entity.User;
import com.thejavacademy.userservice.repo.UserRepo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MongoUserStorageManager implements UserStorageManager {

    private UserRepo userRepo;

    @Override
    public SearchUserResponse searchUser(String term, PageRequest pageRequest) {
        return null;
    }

    @Override
    public SearchUserResponse getUserFriends(String id) {
        return null;
    }

    @Override
    public Optional<User> getUserById(String id) {
        //TODO impllement
        return Optional.empty();
    }
}
