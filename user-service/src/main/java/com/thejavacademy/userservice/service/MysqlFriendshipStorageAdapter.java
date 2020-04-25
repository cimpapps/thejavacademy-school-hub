package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.exception.UserServiceException;
import com.thejavacademy.userservice.mapper.FriendshipRequestMapper;
import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.model.entity.Friendship;
import com.thejavacademy.userservice.repo.MySqlFriendshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.thejavacademy.userservice.exception.UserServiceException.ExceptionType.*;

@Service
public class MysqlFriendshipStorageAdapter implements FriendshipStorageAdapter {

    MySqlFriendshipRepository friendshipRepo;

    public MysqlFriendshipStorageAdapter(MySqlFriendshipRepository friendshipRepo) {
        this.friendshipRepo = friendshipRepo;
    }

    @Override
    public List<Friendship> getFriendships(String id) {
        if (id == null || id.isBlank()) {
            throw new UserServiceException(EMPTY_USER_ID);
        }
        List<Friendship> listOfFriendships = friendshipRepo.findUserFriendhips(id);
        return listOfFriendships;
    }

    @Override
    public Friendship getFriendship(String userOneId, String userTwoId) {
        Friendship friendship = new Friendship();
        friendship.setFriends(userOneId, userTwoId);
        return friendshipRepo.findFriendship(friendship.getUserOneId(), friendship.getUserTwoId())
                .orElse(new Friendship());
    }

    @Override
    public Friendship create(Friendship friendship) {
        return friendshipRepo.findFriendship(friendship.getUserOneId(), friendship.getUserTwoId())
                .map(f -> friendshipRepo.save(friendship))
                .orElseThrow(() -> new UserServiceException(FRIENDSHIP_EXISTS));
    }

    public void update(Friendship friendship) {
        friendshipRepo.findById(friendship.getId())
                .map(f -> friendshipRepo.save(friendship))
                .orElseThrow(() -> new UserServiceException(FRIENDSHIP_DOES_NOT_EXISTS));
    }


    @Override
    public void delete(Friendship friendship) throws UserServiceException {
        friendshipRepo.findById(friendship.getId())
                .ifPresent(friendshipRepo::delete);
    }

    @Override
    public void updateFriendship(FriendshipRequest friendshipRequest) {
        Friendship friendship = FriendshipRequestMapper.dtoToEntity(friendshipRequest);
        switch (friendshipRequest.getActionType()) {
            case REQUESTED:
                create(friendship);
                break;
            case ACCEPT:
                update(friendship);
                break;
            case DENIED:
            case DELETE:
                delete(friendship);
                break;
            default:
                throw new UnsupportedOperationException();

        }

    }


}
