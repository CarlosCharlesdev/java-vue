package com.estudos.loginapi.controller;

import com.estudos.loginapi.model.User;
import com.estudos.loginapi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/cadastro")
    public String cadastro(@RequestBody User user){
        userService.cadastrar(user);
        return "Você foi cadastrado";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        boolean sucesso = userService.login(user.getEmail(), user.getSenha());

        if (sucesso){
            return "Login Efetuado com sucesso";
        } else {
            return "Erro ao fazer login";
        }
    }
}
