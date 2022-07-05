package com.pelinhangisi.userauthservice.service;

import com.pelinhangisi.userauthservice.dao.UserRepository;

import com.pelinhangisi.userauthservice.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    //User kaydetmek için kullanılan bölüm.
    public static User saveUser(@Lazy User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }


    public Optional<User> findByUserName(String username){
        return userRepository.findByUsername(username);
    }


    // bütün userları bulmak için kullanılan bölüm
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }


}
