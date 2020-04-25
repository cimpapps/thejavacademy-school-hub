package com.thejavacademy.userservice.repo;

import com.thejavacademy.userservice.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.List;

public interface MongoUserRepo  {
    //List<User> findByUserOneIdOrUserTwoId(String idOne);
}
