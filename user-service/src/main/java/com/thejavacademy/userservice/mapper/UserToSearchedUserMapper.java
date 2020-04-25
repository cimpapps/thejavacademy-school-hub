package com.thejavacademy.userservice.mapper;

import com.thejavacademy.userservice.model.dto.SearchedUser;
import com.thejavacademy.userservice.model.dto.UserContact;
import com.thejavacademy.userservice.model.dto.UserIdentity;
import com.thejavacademy.userservice.model.entity.User;

public class UserToSearchedUserMapper {

    public static SearchedUser entityToDto(User user){
        SearchedUser searchedUser = new SearchedUser();
        UserIdentity userIdentity = createUserIdentity(user);
        if(user != null){
            searchedUser.setProfilePicture(user.getProfilePicture());
            searchedUser.setUserIdentity(userIdentity);
        }
        return searchedUser;
    }

//    public static User dtoToEntity(SearchedUser searchedUser, UserContact userContact){
//        User user = new User();
//        UserIdentity userIdentity = searchedUser.getUserIdentity();
//        if(userIdentity != null) {
//            user.setUsername(userIdentity.getUsername());
//            user.setFirstName(userIdentity.getFirstName());
//            user.setLastName(userIdentity.getLastName());
//            user.setProfilePicture(userIdentity.getProfilePicture());
//        }
//        if(userContact != null) {
//            user.setEmail(userContact.getEmail());
//            user.setPhoneNumber(userContact.getPhoneNumber());
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
