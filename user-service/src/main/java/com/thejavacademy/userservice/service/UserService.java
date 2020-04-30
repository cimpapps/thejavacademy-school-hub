package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.exception.UserServiceException;
import com.thejavacademy.userservice.mapper.UserMapper;
import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.UserIdentity;
import com.thejavacademy.userservice.model.dto.UserResponse;
import com.thejavacademy.userservice.model.entity.User;
import com.thejavacademy.userservice.model.messages.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public UserService(UserStorageAdapter userStorageAdapter) {

    }


    public UserResponse getUser(String id) {
        if(id == null || id.trim().isEmpty()){
            throw new UserServiceException(EMPTY_USER_ID);
        }
        User user = userStorageAdapter.getUserById(id).orElseThrow(() -> new UserServiceException(USER_NOT_FOUND));
        return UserMapper.userToUserResponse(user);
    }

    public void deleteUser(String id) {
        if(id == null || id.trim().isEmpty()){
            throw new UserServiceException(EMPTY_USER_ID);
        }
        userStorageAdapter.deleteUser(id);
    }



    //TODO not sure what to do here. Ask about blbla
    public SearchUserResponse getFriends(String id) {
        Optional<User> userOptional = userStorageAdapter.getUserById(id);
        if(userOptional.isPresent()) {
            kafkaUserProducer.sendUserEvent(UserMapper.userToUserEvent(userOptional.get()));
            log.info("User sent to topic");
        }
        return userStorageAdapter.getUserFriends(id);
    }

    public User save(User user) {
        return userStorageAdapter.save(user);
    }

    //TODO:delete this method after testing
    public List<UserIdentity> getUsers() {
        return userStorageAdapter.getUsers();
    }
}
