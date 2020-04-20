package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.exception.UserServiceException;
import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.SearchedUser;
import com.thejavacademy.userservice.model.dto.UserIdentity;
import com.thejavacademy.userservice.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class UserServiceGetFriendsTest {

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UserService userService(UserStorageManager userStorageManager) {
            return new UserServiceImpl(userStorageManager);
        }
    }

    @Autowired
    UserService userService;

    @MockBean
    UserStorageManager userStorageManager;


    @Test
    public void givenStorageManagerReturnsEmptyFriends_whenGetFriends_expectedEmptyResponse() {
        given(userStorageManager.getUserById("A")).willReturn(Optional.of(new User()));
        final SearchUserResponse expected = new SearchUserResponse();
        given(userStorageManager.getUserFriends("A")).willReturn(expected);
        assertEquals(expected, userService.getFriends("A"));
    }

    @Test
    public void testGetFriends() {
        final SearchUserResponse expectedFriends = buildSearchUserResponse(5);
        given(userStorageManager.getUserById("A")).willReturn(Optional.of(new User()));
        given(userStorageManager.getUserFriends("A")).willReturn(expectedFriends);
        final SearchUserResponse actualFriends = userService.getFriends("A");
        Assertions.assertEquals(actualFriends, expectedFriends);
    }

    @Test
    public void givenWronUserID_whenGetFriends_ExpectedThrownUserNotFound() {
        given(userStorageManager.getUserById("A")).willReturn(Optional.empty());
        assertThrowsType(UserServiceException.ExceptionType.USER_NOT_FOUND, () -> userService.getFriends("A"));
    }


    @Test
    public void givenStorageManagerThrowsRuntimeException_whenGetFriends_expectedThrownUserServiceException() {
        given(userStorageManager.getUserById("A")).willReturn(Optional.of(new User()));
        given(userStorageManager.getUserFriends("A")).willThrow(new RuntimeException());
        assertThrowsType(UserServiceException.ExceptionType.SERVER_ERROR, () -> userService.getFriends("A"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"     ", ""})
    @NullSource
    public void givenUserIdNull_whenGetFriends_expectedThrownUserServiceException(String id) {
        assertThrowsType(UserServiceException.ExceptionType.EMTPY_USER_ID, () -> userService.getFriends(id));
    }

    public void assertThrowsType(UserServiceException.ExceptionType type, Runnable runnable) {
        try {
            runnable.run();
            fail();
        } catch (UserServiceException ex) {
            assertEquals(type, ex.getType());
        }
    }

    private SearchUserResponse buildSearchUserResponse(int nrOfUsers) {
        List<SearchedUser> users = new ArrayList<>();
        for (int i = 0; i < nrOfUsers; i++) {
            SearchedUser searchedUser = new SearchedUser();
            final UserIdentity userIdentity = new UserIdentity();
            userIdentity.setId(String.valueOf(i));
            userIdentity.setFirstName(String.valueOf(i));
            userIdentity.setLastName(String.valueOf(i));
            userIdentity.setUsername(String.valueOf(i));
            searchedUser.setUserIdentity(userIdentity);
            users.add(searchedUser);
        }
        final SearchUserResponse searchUserResponse = new SearchUserResponse();
        searchUserResponse.setUsers(users);
        return searchUserResponse;
    }

}