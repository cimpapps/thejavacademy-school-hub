package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.exception.FriendshipServiceException;
import com.thejavacademy.userservice.exception.UserServiceException;
import com.thejavacademy.userservice.mapper.FriendshipRequestMapper;
import com.thejavacademy.userservice.model.dto.ActionType;
import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.model.entity.Friendship;
import com.thejavacademy.userservice.repo.MySqlFriendshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MysqlFriendshipStorageAdapter implements FriendshipStorageAdapter<String> {

    MySqlFriendshipRepository friendshipRepo;

    public MysqlFriendshipStorageAdapter(MySqlFriendshipRepository friendshipRepo) {
        this.friendshipRepo = friendshipRepo;
    }

    @Override
    public List<Friendship> getFriendships(String id) {
        if (id == null || id.isBlank()) {
            throw new UserServiceException(UserServiceException.ExceptionType.EMPTY_USER_ID);
        }
        List<Friendship> listOfFriendships = friendshipRepo.findFriendshipsById(id);
        return listOfFriendships;
    }

    @Override
    public Friendship getRelation(String userOneId, String userTwoId) {
        Optional<Friendship> fOptional = friendshipRepo.findByUserOneIdAndUserTwoId(userOneId, userTwoId);
        return null;
    }

    @Override
    public Friendship save(Friendship friendship) {
        Friendship saved = null;
        Optional<Friendship> fOptional = friendshipRepo.findByUserOneIdAndUserTwoId(friendship.getUserOneId(), friendship.getUserTwoId());
        if (fOptional.isEmpty()) {
            saved = friendshipRepo.save(friendship);
        }
        return saved;
    }

    public void update(Friendship friendship) {
        Friendship saved = null;
        Optional<Friendship> fOptional = friendshipRepo.findByUserOneIdAndUserTwoId(friendship.getUserOneId(), friendship.getUserTwoId());
        if (fOptional.isPresent()) {
            saved = friendshipRepo.save(friendship);
        }
    }


    @Override
    public void delete(Friendship friendship) {
        if (friendship == null) {
            throw new FriendshipServiceException(FriendshipServiceException.ExceptionType.NULL_INSTANCE);
        }
        Optional<Friendship> fOptional = friendshipRepo.findByUserOneIdAndUserTwoId(friendship.getUserOneId(), friendship.getUserTwoId());
        if (fOptional.isPresent())
            friendshipRepo.delete(friendship);
    }

    @Override
    public void updateFriendship(FriendshipRequest friendshipRequest) {
        Friendship friendship = FriendshipRequestMapper.dtoToEntity(friendshipRequest);
        switch (friendshipRequest.getActionType()) {
            case REQUESTED:
                save(friendship);
                break;
            case ACCEPT:
                update(friendship);
                break;
            case DENIED:
                delete(friendship);

            default:
                throw new UnsupportedOperationException();

        }

    }


}
