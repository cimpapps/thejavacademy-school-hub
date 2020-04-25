package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.model.entity.Friendship;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipServiceImpl implements FriendshipService {

    FriendshipStorageAdapter friendshipStorageAdapter;

    public FriendshipServiceImpl(FriendshipStorageAdapter friendshipStorageAdapter) {
        this.friendshipStorageAdapter = friendshipStorageAdapter;
    }

    @Override
    public List<Friendship> getFriendships(String id) {
        return null;
    }

    @Override
    public Friendship getRelation(String userOneId, String userTwoId) {
        return friendshipStorageAdapter.getRelation(userOneId, userTwoId);
    }

    @Override
    public void updateFriendship(FriendshipRequest friendshipRequest) {
        friendshipStorageAdapter.updateFriendship(friendshipRequest);
    }


    @Override
    public void delete(Friendship friendship) {
        friendshipStorageAdapter.delete(friendship);
    }
}
