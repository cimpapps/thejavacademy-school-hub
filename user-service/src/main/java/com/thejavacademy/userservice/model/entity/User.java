package com.thejavacademy.userservice.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thejavacademy.userservice.model.dto.UserContact;
import com.thejavacademy.userservice.model.dto.UserIdentity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Data
public class User {

    @Id
    private String id;
    private String username;
    private String lastName;
    private String firstName;
    private String profilePicture;
    private String email;
    private String phoneNumber;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
