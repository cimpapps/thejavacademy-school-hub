package com.thejavacademy.userservice.repo;

import com.thejavacademy.userservice.model.entity.Friendship;
import com.thejavacademy.userservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface MySqlFriendshipRepository extends JpaRepository<Friendship, String> {
    @Query(value = "SELECT f from Friendship f WHERE userOneId = ?1 or userTwoId = ?1", nativeQuery = false)
    List<Friendship> findFriendshipsById(String id);

    //@Query(value="select ")
    Optional<Friendship> findByUserOneIdAndUserTwoId(String userOneId, String userTwoId);
}
