package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.exception.FriendshipServiceException;
import com.thejavacademy.userservice.exception.UserServiceException;
import com.thejavacademy.userservice.mapper.UserMapper;
import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.SearchedUser;
import com.thejavacademy.userservice.model.entity.Friendship;
import com.thejavacademy.userservice.model.entity.User;
import com.thejavacademy.userservice.repo.MySqlUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MysqlUserStorageAdapter implements UserStorageAdapter<String>{

    private MySqlUserRepo userRepo;
    private MysqlFriendshipStorageAdapter friendshipStorageAdapter;

    public MysqlUserStorageAdapter(MySqlUserRepo userRepo, MysqlFriendshipStorageAdapter friendshipStorageAdapter) {
        this.userRepo = userRepo;
        this.friendshipStorageAdapter = friendshipStorageAdapter;
    }

    @Override
    public Optional<User> getUserById(String id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserServiceException(UserServiceException.ExceptionType.USER_NOT_FOUND));
        return Optional.of(user);
    }

    @Override
    public User save(User user) {
        if(user == null){
            throw new UserServiceException(UserServiceException.ExceptionType.USER_NOT_FOUND);
        }
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserServiceException(UserServiceException.ExceptionType.USER_NOT_FOUND));
        userRepo.delete(user);
    }

    @Override
    public boolean areTheyFriends(String userOneId, String userTwoId) {
        return false;
    }

    @Override
    public Friendship getRelationship(String userOneId, String userTwoId){
        Friendship friendship = friendshipStorageAdapter.getFriendship(userOneId, userTwoId);
        if(friendship == null ) throw  new FriendshipServiceException(FriendshipServiceException.ExceptionType.FRIENDSHIP_NOT_FOUND);
        return friendship;
    }

    @Override
    public boolean areTheyInARelationship(String userOneId, String userTwoId) {
        List<Friendship> friendships = friendshipStorageAdapter.getFriendships(userOneId);
        if(!friendships.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public SearchUserResponse searchUser(String term) {

        return null;
    }


    @Override
    public SearchUserResponse getUserFriends(String id) {
        SearchUserResponse searchUserResponse = new SearchUserResponse();

        List<Friendship> listOfFriendships= friendshipStorageAdapter.getFriendships(id);
        List<String> usersIds = extractFriendsIds(listOfFriendships, id);
        List<User> listOfFriends = userRepo.findByIdIn(usersIds);
        List<SearchedUser> searchedUsers = listOfFriends.stream().map(UserMapper::entityToDto)
                .collect(Collectors.toList());

        searchUserResponse.setUsers(searchedUsers);
       return searchUserResponse;
    }

    /**
     *
     * @param -friendshipList
     * @param -idOfUserWhichWeAreSearchingFriendsFor - index which we are searching friends for
     * @return returneza indexul prietenilor lui idOfUserWhichWeAreSearchingFriendsFor
     */
    private List<String> extractFriendsIds(List<Friendship> friendshipList, String currentUserId){
        return friendshipList.stream()
                .map(friendship -> friendship.getFriendId(currentUserId))
                .collect(Collectors.toList());
    }
}
