package com.thejavacademy.userservice.util;

public enum FriendshipType {
    NOT_FRIENDS(0),  FRIENDS(1),PENDING(2);
        int relation;

        FriendshipType(int relation){
            this.relation = relation;
        }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }
}
