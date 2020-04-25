package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.ActionType;
import com.thejavacademy.userservice.model.entity.Friendship;
import com.thejavacademy.userservice.util.FriendshipType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;

public class FriendshipServiceGetFriendshipTest {


    final FriendshipStorageAdapter storageAdapter = Mockito.mock(FriendshipStorageAdapter.class);
    FriendshipService service = new FriendshipServiceImpl(storageAdapter);


    @Test
    public void testGetFriendship() {

        Friendship expectedFriendship = new Friendship();
        expectedFriendship.setId("123");
        expectedFriendship.setUserOneId("A");
        expectedFriendship.setUserTwoId("B");
        expectedFriendship.setRelationshipStatus(ActionType.ACCEPT);
        expectedFriendship.setActionUserId("userOne");
        given(storageAdapter.getRelation("A", "B")).willReturn(expectedFriendship);
        final Friendship actualFriendship = service.getRelation("A", "B");
        actualFriendship.setId("234");

        Assertions.assertEquals(actualFriendship, expectedFriendship);
    }

}
