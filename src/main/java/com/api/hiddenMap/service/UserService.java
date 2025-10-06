package com.api.hiddenMap.service;

import com.api.hiddenMap.entity.UserEntity;
import com.api.hiddenMap.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity>  getAllUser(){
        return userRepository.findAll();
    }

    public UserEntity  findByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }

    public UserEntity registerUser(UserEntity user){
        return userRepository.save(user);
    }

}
