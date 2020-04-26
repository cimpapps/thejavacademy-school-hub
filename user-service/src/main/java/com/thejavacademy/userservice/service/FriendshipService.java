package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.mapper.FriendshipRequestMapper;
import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.model.entity.Friendship;
import org.springframework.stereotype.Service;

@Service
public class FriendshipService {

    private FriendshipStorageAdapter friendshipStorageAdapter;
    private KafkaFriendshipService kafkaFriendshipService;

    public FriendshipService(FriendshipStorageAdapter friendshipStorageAdapter, KafkaFriendshipService kafkaFriendshipService) {
        this.friendshipStorageAdapter = friendshipStorageAdapter;
        this.kafkaFriendshipService = kafkaFriendshipService;
    }


    public Friendship getFriendship(String userOneId, String userTwoId) {
        return friendshipStorageAdapter.getFriendship(userOneId, userTwoId);
    }

    public void updateFriendship(FriendshipRequest friendshipRequest) {
        friendshipStorageAdapter.updateFriendship(friendshipRequest);
        kafkaFriendshipService.sendFriendshipEvent(FriendshipRequestMapper.requestToEvent(friendshipRequest));
    }

}
