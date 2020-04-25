package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.exception.UserServiceException;
import com.thejavacademy.userservice.mapper.UserToUserResponseMapper;
import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.UserResponse;
import com.thejavacademy.userservice.model.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import static com.thejavacademy.userservice.exception.UserServiceException.ExceptionType.EMPTY_USER_ID;
import static com.thejavacademy.userservice.exception.UserServiceException.ExceptionType.USER_NOT_FOUND;

@Service
public class UserServiceImpl implements UserService<String> {


    private UserStorageAdapter userStorageAdapter;

    public UserServiceImpl( UserStorageAdapter userStorageAdapter) {
        this.userStorageAdapter = userStorageAdapter;
    }



    @Override
    public UserResponse getUser(String id) {
//        if(id == null || id.isBlank()){
//            throw new UserServiceException(EMTPY_USER_ID);
//        }
//        User user = userStorageAdapter.getUserById(id).orElseThrow(() -> new UserServiceException(USER_NOT_FOUND));
//        return UserToUserResponseMapper.entityToDto(user);
        return null;
    }

    @Override
    public void deleteUser(String id) {
        if(id == null || id.isBlank()){
            throw new UserServiceException(EMPTY_USER_ID);
        }
        userStorageAdapter.deleteUser(id);
    }



//    @Override
//    public SearchUserResponse searchUser(String term, int page, int limit) {
//        PageRequest pageRequest = PageRequest.of(page, limit);
//        return userStorageAdapter.searchUser(term, pageRequest);
//    }
    @Override
    public SearchUserResponse searchUser(String term) {
       // PageRequest pageRequest = PageRequest.of(page, limit);
        return userStorageAdapter.searchUser(term);
    }

    @Override
    public SearchUserResponse getFriends(String id) {
        System.out.println("am intrat din testare aici");
//        if (id == null || id.isBlank()) {
//            throw new UserServiceException(EMTPY_USER_ID);
//        }
        //userStorageAdapter.getUserById(id).orElseThrow(() -> new UserServiceException(USER_NOT_FOUND));
        //try {
            return userStorageAdapter.getUserFriends(id);
        //} catch (RuntimeException ex) {
          //  throw new UserServiceException(UserServiceException.ExceptionType.SERVER_ERROR);
       // }
    }

    @Override
    public User save(User user) {
        return userStorageAdapter.save(user);
    }

    public SearchUserResponse getFriendsOf(Long id) {
        return userStorageAdapter.getUserFriends(id);
    }
}
