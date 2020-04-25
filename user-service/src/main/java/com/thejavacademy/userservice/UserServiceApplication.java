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
public class UserServiceApplication{
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
