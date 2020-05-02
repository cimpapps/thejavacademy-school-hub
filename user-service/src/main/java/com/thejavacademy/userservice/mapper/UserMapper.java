package com.thejavacademy.userservice.mapper;

import com.thejavacademy.userservice.model.dto.SearchedUser;
import com.thejavacademy.userservice.model.dto.UserContact;
import com.thejavacademy.userservice.model.dto.UserIdentity;
import com.thejavacademy.userservice.model.dto.UserResponse;
import com.thejavacademy.userservice.model.entity.User;
import com.thejavacademy.userservice.model.messages.UserEvent;

import java.util.Optional;

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

    public static UserEvent toUserEvent(User user){
        UserEvent userEvent = new UserEvent();
        if(user != null){
            userEvent.setId(user.getId());
            userEvent.setUsername(user.getUsername());
            userEvent.setEmail(user.getEmail());
            userEvent.setLastName(user.getLastName());
            userEvent.setPhoneNumber(user.getPhoneNumber());
            userEvent.setProfilePicture(user.getProfilePicture());
        }
       //return Optional.of(userEvent);
        return userEvent;
    }

    public static UserResponse userToUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        UserContact userContact = new UserContact();
        userContact.setPhoneNumber(user.getPhoneNumber());
        userContact.setEmail(user.getEmail());
        userResponse.setUserContact(userContact);
        userResponse.setUserIdentity(buildUserIdentity(user));
        userResponse.setProfilePicture(user.getProfilePicture());
        return userResponse;
    }


//TODO: change accesor to private
    public static UserIdentity buildUserIdentity(User user){
        UserIdentity userIdentity = new UserIdentity();
        userIdentity.setUsername(user.getUsername());
        userIdentity.setProfilePicture(user.getProfilePicture());
        userIdentity.setLastName(user.getLastName());
        userIdentity.setFirstName(user.getFirstName());
        userIdentity.setId(user.getId());
        return userIdentity;
    }
}
