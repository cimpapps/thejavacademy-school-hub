package com.thejavacademy.userservice.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FriendshipRequest {

    private String id;
    private String userOneId;
    private String userTwoId;
    private ActionType actionType;
    private String triggeredBy;


    public String to() {
        return triggeredBy.equals(userOneId) ? userTwoId : userOneId;
    }

}
