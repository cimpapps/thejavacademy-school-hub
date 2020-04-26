package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.exception.UserServiceException;
import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.UserResponse;
import com.thejavacademy.userservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.thejavacademy.userservice.exception.UserServiceException.ExceptionType.EMPTY_USER_ID;

@Service
public class UserService {


    private UserStorageAdapter userStorageAdapter;

    public UserService(UserStorageAdapter userStorageAdapter) {
        this.userStorageAdapter = userStorageAdapter;
    }



    public UserResponse getUser(String id) {
//        if(id == null || id.isBlank()){
//            throw new UserServiceException(EMTPY_USER_ID);
//        }
//        User user = userStorageAdapter.getUserById(id).orElseThrow(() -> new UserServiceException(USER_NOT_FOUND));
//        return UserToUserResponseMapper.entityToDto(user);
        return null;
    }

    public void deleteUser(String id) {
        if(id == null || id.trim().isEmpty()){
            throw new UserServiceException(EMPTY_USER_ID);
        }
        userStorageAdapter.deleteUser(id);
    }



    //TODO not sure what to do here. Ask about blbla
    public SearchUserResponse getFriends(String id) {
        System.out.println("am intrat din testare aici");

            return userStorageAdapter.getUserFriends(id);
        //} catch (RuntimeException ex) {
          //  throw new UserServiceException(UserServiceException.ExceptionType.SERVER_ERROR);
       // }
    }

    public User save(User user) {
        return userStorageAdapter.save(user);
    }

}
