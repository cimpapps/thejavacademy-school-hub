package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.exception.UserServiceException;
import com.thejavacademy.userservice.mapper.UserMapper;
import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.UserIdentity;
import com.thejavacademy.userservice.model.dto.UserResponse;
import com.thejavacademy.userservice.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.thejavacademy.userservice.exception.UserServiceException.ExceptionType.EMPTY_USER_ID;
import static com.thejavacademy.userservice.exception.UserServiceException.ExceptionType.USER_NOT_FOUND;

@Slf4j
@Service
public class UserService {


    private UserStorageAdapter userStorageAdapter;
    private KafkaUserProducer kafkaUserProducer;

    public UserService(UserStorageAdapter userStorageAdapter, KafkaUserProducer kafkaUserProducer) {
        this.userStorageAdapter = userStorageAdapter;
        this.kafkaUserProducer = kafkaUserProducer;
    }




    public UserResponse getUser(String id) {
        if(id == null || id.trim().isEmpty()){
            throw new UserServiceException(EMPTY_USER_ID);
        }
        User user = userStorageAdapter.getUserById(id).orElseThrow(() -> new UserServiceException(USER_NOT_FOUND));
        return UserMapper.userToUserResponse(user);
    }

    public void deleteUser(String id) {
        userStorageAdapter.getUserById("");
        if(id == null || id.trim().isEmpty()){
            throw new UserServiceException(EMPTY_USER_ID);
        }
        userStorageAdapter.deleteUser(id);
    }

    public SearchUserResponse getFriends(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new UserServiceException(EMPTY_USER_ID);
        }
        userStorageAdapter.getUserById(id).orElseThrow(() -> new UserServiceException(USER_NOT_FOUND));
        try {
            return userStorageAdapter.getUserFriends(id);
        } catch (Exception ex) {
            throw new UserServiceException(UserServiceException.ExceptionType.SERVER_ERROR);
        }
    }
    public User save(User user) {
        return userStorageAdapter.save(user);
    }

    //TODO:delete this method after testing
    public List<UserIdentity> getUsers() {
        return userStorageAdapter.getUsers();
    }
}
