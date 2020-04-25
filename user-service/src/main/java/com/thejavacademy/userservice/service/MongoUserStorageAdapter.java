package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.exception.UserServiceException;
import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.entity.User;
import com.thejavacademy.userservice.repo.MongoUserRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
public class MongoUserStorageAdapter {

//    private MongoUserRepo mongoUserRepo;
//
//    public MongoUserStorageAdapter(MongoUserRepo mongoUserRepo) {
//        this.mongoUserRepo = mongoUserRepo;
//    }

//    @Override
//    public SearchUserResponse searchUser(String term, PageRequest pageRequest) {
//       // userRepo.fin
//        return null;
//    }
//
//    @Override
//    public SearchUserResponse getUserFriends(String idOne) {
//        return null;
//    }


//    @Override
//    public SearchUserResponse getUserFriends(String idOne) {
//        List<User> users = userRepo.findByUserOneIdOrUserTwoId(idOne);
//        SearchUserResponse searchUserResponse = new SearchUserResponse();
//       // List<SearchedUser> searchedUsers = users.stream().map(UserToSearchedUserMapper::entityToDto).collect(Collectors.toList());
//        //searchUserResponse.setUsers(searchedUsers);
//
//        List<SearchUserResponse> searchedUsers = users.stream()
//                .map(UserToSearchedUserMapper::entityToDto)
//                .map(searchedUser -> {searchUserResponse.getUsers().add(searchedUser);return searchUserResponse;})
//                .collect(Collectors.toList());
//
//        return searchUserResponse;
//    }

//    @Override
//    public Optional<User> getUserById(String id) {
//        Optional<User> userOpt =  mongoUserRepo.findById(id);
//        return userOpt;
//    }

//    @Override
//    public void deleteUser(String id) {
//        User user = mongoUserRepo.findById(id).orElseThrow(() -> new UserServiceException(UserServiceException.ExceptionType.USER_NOT_FOUND));
//        mongoUserRepo.delete(user);
//    }


}
