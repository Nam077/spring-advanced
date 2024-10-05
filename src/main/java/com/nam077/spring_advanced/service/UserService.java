package com.nam077.spring_advanced.service;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.nam077.spring_advanced.dto.UserDTO;
import com.nam077.spring_advanced.exception.ConflictException;
import com.nam077.spring_advanced.model.User;
import com.nam077.spring_advanced.repository.UserReposistory;
import com.nam077.spring_advanced.util.Utils;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    private final UserReposistory userReposistory;

    public UserService(UserReposistory userReposistory) {
        this.userReposistory = userReposistory;
    }

    public boolean isEmailExist(String email) {
        return userReposistory.existsByEmail(email);
    }

    @Transactional(rollbackOn = Exception.class)
    public UserDTO createUser(UserDTO userDTO) {
        try {
            if (isEmailExist(userDTO.getEmail())) {
                throw new ConflictException("Email already exists");
            }

            User user = new User();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());

            User newUser = this.userReposistory.save(user);
            return Utils.convertEntityToDto(newUser, UserDTO.class);

        } catch (ConflictException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user due to unexpected error");
        }
    }

}
