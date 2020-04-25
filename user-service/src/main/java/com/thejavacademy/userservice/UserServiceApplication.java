package com.thejavacademy.userservice;

import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.entity.Friendship;
import com.thejavacademy.userservice.repo.MySqlFriendshipRepository;
import com.thejavacademy.userservice.repo.MySqlUserRepo;
import com.thejavacademy.userservice.service.UserServiceImpl;
import com.thejavacademy.userservice.util.FriendshipType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.relation.RelationType;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

	MySqlUserRepo userRepo;
	MySqlFriendshipRepository friendshipRepo;
	UserServiceImpl userService;

	public UserServiceApplication(MySqlUserRepo userRepo, MySqlFriendshipRepository friendshipRepo, UserServiceImpl userService) {
		this.userRepo = userRepo;
		this.friendshipRepo = friendshipRepo;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Friendship f1 = new Friendship();
		f1.setId("id123");
		f1.setUserOneId("1");
		f1.setUserTwoId("2");
		f1.setRelationshipStatus(FriendshipType.FRIENDS);
		f1.setActionUserId(1);

		Friendship f2 = new Friendship();
		f2.setId("id456");
		f2.setUserOneId("2");
		f2.setUserTwoId("4");
		f2.setRelationshipStatus(FriendshipType.FRIENDS);
		f2.setActionUserId(1);

		Friendship f3 = new Friendship();
		f3.setId("id789");
		f3.setUserOneId("2");
		f3.setUserTwoId("4");
		f3.setRelationshipStatus(FriendshipType.FRIENDS);
		f3.setActionUserId(2);

//		friendshipRepo.save(f1);
//		friendshipRepo.save(f2);
//		friendshipRepo.save(f3);

		SearchUserResponse response = userService.getFriends("b");
		//response.getUsers().forEach(System.out::println);
		System.out.println(response);
	}
}
