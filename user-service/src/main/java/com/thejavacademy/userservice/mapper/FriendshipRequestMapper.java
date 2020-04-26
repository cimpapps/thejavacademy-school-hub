package com.thejavacademy.userservice.mapper;

import com.thejavacademy.userservice.model.dto.ActionType;
import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.model.entity.Friendship;

import java.util.UUID;

public class FriendshipRequestMapper {


    public static Friendship dtoToEntity(FriendshipRequest friendshipRequest) {
        Friendship friendship = new Friendship();
        friendship.setFriends(friendshipRequest.getUserOneId(), friendshipRequest.getUserTwoId());
        friendship.setRelationshipStatus(friendshipRequest.getActionType());
        friendship.setActionUserId(friendshipRequest.getTriggeredBy());
        if (friendshipRequest.getId() == null && friendshipRequest.getActionType().equals(ActionType.REQUESTED)) {
            friendship.setId(UUID.randomUUID().toString());
        } else {
            friendship.setId(friendshipRequest.getId());
        }
        return friendship;
    }

}
