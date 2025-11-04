package com.fitness.userservice.service;


import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserRestonse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public UserRestonse register(RegisterRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exist");
        }


        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        User saveduser = repository.save(user);

        UserRestonse userRestonse = new UserRestonse();
        userRestonse.setId(saveduser.getId());
        userRestonse.setEmail(saveduser.getEmail());
        userRestonse.setPassword(saveduser.getPassword());
        userRestonse.setFirstName(saveduser.getFirstName());
        userRestonse.setLastName(saveduser.getLastName());
        userRestonse.setCreatedAt(saveduser.getCreatedAt());
        userRestonse.setUpdatedAt(saveduser.getUpdatedAt());

        return userRestonse;
    }

    public UserRestonse getUserProfile(String userId) {
        User user = repository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found"));


        UserRestonse userRestonse = new UserRestonse();
        userRestonse.setId(user.getId());
        userRestonse.setEmail(user.getEmail());
        userRestonse.setPassword(user.getPassword());
        userRestonse.setFirstName(user.getFirstName());
        userRestonse.setLastName(user.getLastName());
        userRestonse.setCreatedAt(user.getCreatedAt());
        userRestonse.setUpdatedAt(user.getUpdatedAt());


        return userRestonse;
    }
}
