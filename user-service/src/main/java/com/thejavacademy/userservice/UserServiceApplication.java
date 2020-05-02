package com.thejavacademy.userservice;

import com.thejavacademy.userservice.config.KafkaFriendshipConfigs;
import com.thejavacademy.userservice.config.KafkaUserConfigs;
import com.thejavacademy.userservice.model.dto.ActionType;
import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.service.FriendshipService;
import com.thejavacademy.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Autowired
	KafkaFriendshipConfigs kafkaFriendshipConfigs;
	@Autowired
	FriendshipService friendshipService;
	@Autowired
	KafkaUserConfigs kafkaUserConfigs;
	@Autowired
	UserService userService;
	@Override
	public void run(String... args) throws Exception {
		final FriendshipRequest friendshipRequest = new FriendshipRequest();
		friendshipRequest.setActionType(ActionType.REQUESTED);
//		friendshipRequest.setId("dsad");
		friendshipRequest.setTriggeredBy("dsad");
		friendshipRequest.setUserTwoId(UUID.randomUUID().toString());
		friendshipRequest.setUserOneId(UUID.randomUUID().toString());
		friendshipService.updateFriendship(friendshipRequest);
		userService.getFriends("d");


	}
}
