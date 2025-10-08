package com.api.hiddenMap.service;

import com.api.hiddenMap.entity.UserEntity;
import com.api.hiddenMap.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity>  getAllUser(){
        return userRepository.findAll();
    }

    public Optional<UserEntity>  findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserEntity registerUser(UserEntity user){
        return userRepository.save(user);
    }

}
