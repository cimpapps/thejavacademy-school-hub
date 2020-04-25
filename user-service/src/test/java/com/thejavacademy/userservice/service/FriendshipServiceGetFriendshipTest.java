package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.model.dto.ActionType;
import com.thejavacademy.userservice.model.entity.Friendship;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;

public class FriendshipServiceGetFriendshipTest {


    final FriendshipStorageAdapter storageAdapter = Mockito.mock(FriendshipStorageAdapter.class);
    FriendshipService service = new FriendshipService(storageAdapter);


    @Test
    public void testGetFriendship() {

        Friendship expectedFriendship = new Friendship();
        expectedFriendship.setId("123");
        expectedFriendship.setUserOneId("A");
        expectedFriendship.setUserTwoId("B");
        expectedFriendship.setRelationshipStatus(ActionType.ACCEPT);
        expectedFriendship.setActionUserId("userOne");
        given(storageAdapter.getFriendship("A", "B")).willReturn(expectedFriendship);
        final Friendship actualFriendship = service.getFriendship("A", "B");
        actualFriendship.setId("234");

        Assertions.assertEquals(actualFriendship, expectedFriendship);
    }

}
