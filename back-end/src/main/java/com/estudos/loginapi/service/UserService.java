package com.estudos.loginapi.service;

import com.estudos.loginapi.model.User;
import com.estudos.loginapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User cadastrar(User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email já cadastrado");
        }
        return userRepository.save(user);
    }

    public boolean login(String email, String senha){
        return userRepository.findByEmail(email)
                .map(u -> u.getSenha().equals(senha))
                .orElse(false);
    }
}
