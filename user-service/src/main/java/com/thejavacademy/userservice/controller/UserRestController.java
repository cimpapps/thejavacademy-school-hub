package com.thejavacademy.userservice.controller;

import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.UserResponse;
import com.thejavacademy.userservice.model.entity.User;
import com.thejavacademy.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserRestController {


    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    

    @GetMapping("/search")
    public ResponseEntity<SearchUserResponse> searchUser(@RequestParam String term) {
        System.out.println("am intrat in controller searchUser()");
        final SearchUserResponse users = userService.searchUser(term);
        System.out.println(users);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUser(id));
    }


    @GetMapping("/{id}/friends")
    public ResponseEntity<SearchUserResponse> searchUserFriends(@PathVariable String id) {
        SearchUserResponse response = userService.getFriends(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }


}
