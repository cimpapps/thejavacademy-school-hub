package com.thejavacademy.userservice.controller;

import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.model.entity.Friendship;
import com.thejavacademy.userservice.service.FriendshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friendships")
public class FriendshipController {

    private FriendshipService friendshipService;

    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    @PostMapping
    public ResponseEntity<FriendshipRequest> updateFriendship(@RequestBody FriendshipRequest friendshipRequest) {
        friendshipService.updateFriendship(friendshipRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userOneId}/{userTwoId}")
    public ResponseEntity<Friendship> getFriendship(@PathVariable String userOneId, @PathVariable String userTwoId) {
        Friendship friendship = friendshipService.getFriendship(userOneId, userTwoId);
        return new ResponseEntity<>(friendship, HttpStatus.OK);
    }
}
