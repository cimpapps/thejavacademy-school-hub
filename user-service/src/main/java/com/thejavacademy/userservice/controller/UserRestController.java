package com.thejavacademy.userservice.controller;

import com.thejavacademy.userservice.model.dto.SearchUserResponse;
import com.thejavacademy.userservice.model.dto.UserResponse;
import com.thejavacademy.userservice.service.UserService;
import org.springframework.data.domain.PageRequest;
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
    public ResponseEntity<SearchUserResponse> searchUser(@RequestParam(required = false) String term,
                                                         @RequestParam(defaultValue = "0", required = false) int page,
                                                         @RequestParam(defaultValue = "100") int limit, @RequestParam PageRequest pageRequest) {
        final SearchUserResponse users = userService.searchUser(term, page, limit);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String id){
        return ResponseEntity.ok(userService.getUser(id));
    }


    @GetMapping("/{id}/friends")
    public ResponseEntity<SearchUserResponse> searchUserFriends(@PathVariable String id){
        return ResponseEntity.ok(userService.getFriends(id));
    }



}
