package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.model.entity.Friendship;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipService {

    private FriendshipStorageAdapter friendshipStorageAdapter;

    public FriendshipService(FriendshipStorageAdapter friendshipStorageAdapter) {
        this.friendshipStorageAdapter = friendshipStorageAdapter;
    }


    public Friendship getFriendship(String userOneId, String userTwoId) {
        return friendshipStorageAdapter.getFriendship(userOneId, userTwoId);
    }

    public void updateFriendship(FriendshipRequest friendshipRequest) {
        friendshipStorageAdapter.updateFriendship(friendshipRequest);
    }

}
