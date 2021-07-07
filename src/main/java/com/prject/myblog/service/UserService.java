package com.prject.myblog.service;

import com.prject.myblog.model.User;
import com.prject.myblog.dto.SignupRequestDto;
import com.prject.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();

        requestDto.isValidUsername();

        String password = passwordEncoder.encode(requestDto.getPassword());
        String email = requestDto.getEmail();

        Optional<User> found = userRepository.findByUsername(username);

        requestDto.isSameUsernamePassword();

        User user = new User(username, password,email);
        userRepository.save(user);
    }
}