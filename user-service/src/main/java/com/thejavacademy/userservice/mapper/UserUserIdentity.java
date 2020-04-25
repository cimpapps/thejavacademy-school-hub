package com.thejavacademy.userservice.mapper;

import com.thejavacademy.userservice.model.dto.UserContact;
import com.thejavacademy.userservice.model.dto.UserIdentity;
import com.thejavacademy.userservice.model.entity.User;

public class UserUserIdentity {

    public static UserIdentity entityToDto(User user){
        UserIdentity userIdentity = new UserIdentity();
        if(user != null) {
            userIdentity.setId(user.getId());
            userIdentity.setFirstName(user.getFirstName());
            userIdentity.setLastName(user.getLastName());
            userIdentity.setProfilePicture(user.getProfilePicture());
            userIdentity.setUsername(user.getUsername());
        }
        return userIdentity;
    }

//    public static User dtoToEntity(UserIdentity userIdentity, UserContact userContact){
//        User user = new User();
//        if(userIdentity != null) {
//            user.setUsername(userIdentity.getUsername());
//            user.setFirstName(userIdentity.getFirstName());
//            user.setLastName(userIdentity.getLastName());
//            user.setProfilePicture(userIdentity.getProfilePicture());
//            if (userContact != null) {
//                user.setEmail(userContact.getEmail());
//                user.setPhoneNumber(userContact.getPhoneNumber());
//            }
//        }
//        return user;
//    }
}
