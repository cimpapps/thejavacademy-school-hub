package com.thejavacademy.userservice.mapper;

import com.thejavacademy.userservice.model.dto.UserContact;
import com.thejavacademy.userservice.model.dto.UserIdentity;
import com.thejavacademy.userservice.model.entity.User;

public class UserUserContact {

    public static UserContact entityToDto(User user){
        UserContact userContact = new UserContact();
        if(user != null){
            userContact.setEmail(user.getEmail());
            userContact.setPhoneNumber(user.getPhoneNumber());
        }
        return userContact;
    }

//    public static User dtoToEntity(UserContact userContact){
//        User user = new User();
//        UserIdentity userIdentity = userContact.
//        if(userContact != null){
//            if(userIdentity != null) {
//                user.setUsername(userIdentity.getUsername());
//                user.setFirstName(userIdentity.getFirstName());
//                user.setLastName(userIdentity.getLastName());
//                user.setProfilePicture(userIdentity.getProfilePicture());
//            }
//            user.setPhoneNumber(userContact.getPhoneNumber());
//            user.setEmail(userContact.getEmail());
//        }
//        return user;
//    }


    private static UserIdentity createUserIdentity(User user){
        UserIdentity userIdentity = new UserIdentity();
        userIdentity.setUsername(user.getUsername());
        userIdentity.setProfilePicture(user.getProfilePicture());
        userIdentity.setLastName(user.getLastName());
        userIdentity.setFirstName(user.getFirstName());
        userIdentity.setId(user.getId());
        return userIdentity;
    }
}
