package com.thejavacademy.userservice.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class UserServiceDeleteFriendsTest {


//    final UserStorageAdapter adapterMock = Mockito.mock(UserStorageAdapter.class);
//
//    UserService userService = new UserServiceImpl(adapterMock);


    @InjectMocks
    UserService userService;
    @Mock
    UserStorageAdapter storageAdapter;



    @Test
    public void deleteUserTest(){

    }




}
