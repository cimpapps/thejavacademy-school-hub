package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.model.entity.Friendship;
import com.thejavacademy.userservice.repo.MySqlFriendshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FriendshipService {

    List<Friendship> getFriendships(String id);
    Friendship getFriendship(String userOneId, String userTwoId);
    void updateFriendship(FriendshipRequest friendshipRequest);
    void delete(Friendship friendship);

}
