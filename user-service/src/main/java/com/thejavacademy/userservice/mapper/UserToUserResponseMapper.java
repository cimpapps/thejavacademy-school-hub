package com.thejavacademy.userservice.mapper;

import com.thejavacademy.userservice.model.dto.UserContact;
import com.thejavacademy.userservice.model.dto.UserIdentity;
import com.thejavacademy.userservice.model.dto.UserResponse;
import com.thejavacademy.userservice.model.entity.User;

public class UserToUserResponseMapper {

    public static UserResponse entityToDto(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setProfilePicture(user.getProfilePicture());
        userResponse.setUserIdentity(UserUserIdentity.entityToDto(user));
        userResponse.setUserContact(UserUserContact.entityToDto(user));
        return userResponse;
    }

    public static User dtoToUser(UserResponse userResponse){
        User user = new User();
        UserIdentity userIdentity = userResponse.getUserIdentity();
        UserContact userContact = userResponse.getUserContact();
        if(userResponse != null) {
            if (userIdentity != null) {
                user.setUsername(userIdentity.getUsername());
                user.setProfilePicture(userIdentity.getProfilePicture());
                user.setFirstName(userIdentity.getFirstName());
                user.setLastName(userIdentity.getLastName());
            }
            if (userContact != null) {
                user.setPhoneNumber(userContact.getPhoneNumber());
                user.setEmail(userContact.getEmail());
            }
        }
        return user;
    }

//    private static UserIdentity createUserIdentity(User user){
//        UserIdentity userIdentity = new UserIdentity();
//        userIdentity.setUsername(user.getUsername());
//        userIdentity.setProfilePicture(user.getProfilePicture());
//        userIdentity.setLastName(user.getLastName());
//        userIdentity.setFirstName(user.getFirstName());
//        userIdentity.setId(user.getId());
//        return userIdentity;
//    }
}
