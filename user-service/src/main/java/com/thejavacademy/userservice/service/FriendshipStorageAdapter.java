package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.model.entity.Friendship;

import java.util.List;

public interface FriendshipStorageAdapter<Serializable> {


    List<Friendship> getFriendships(String id);
    Friendship getRelation(String userOneId, String userTwoId);
    Friendship save(Friendship friendship);
    void delete(Friendship friendship);
    void updateFriendship(FriendshipRequest friendshipRequest);
}
