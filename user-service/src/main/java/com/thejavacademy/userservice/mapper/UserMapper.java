package com.thejavacademy.userservice.mapper;

import com.thejavacademy.userservice.model.dto.SearchedUser;
import com.thejavacademy.userservice.model.dto.UserIdentity;
import com.thejavacademy.userservice.model.entity.User;

public class UserMapper {


    public static SearchedUser entityToDto(User user){
        SearchedUser searchedUser = new SearchedUser();
        UserIdentity userIdentity = buildUserIdentity(user);
        if(user != null){
            searchedUser.setProfilePicture(user.getProfilePicture());
            searchedUser.setUserIdentity(userIdentity);
        }
        return searchedUser;
    }



    private static UserIdentity buildUserIdentity(User user){
        UserIdentity userIdentity = new UserIdentity();
        userIdentity.setUsername(user.getUsername());
        userIdentity.setProfilePicture(user.getProfilePicture());
        userIdentity.setLastName(user.getLastName());
        userIdentity.setFirstName(user.getFirstName());
        userIdentity.setId(user.getId());
        return userIdentity;
    }
}
