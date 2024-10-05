package com.nam077.spring_advanced.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nam077.spring_advanced.model.User;

@Reposistory
public interface UserReposistory extends JpaRepository<User, UUID> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email")
    boolean existsByEmail(String email);

}
