package edu.miu.waa.lab.controller;

import edu.miu.waa.lab.entity.dto.LoginRequest;
import edu.miu.waa.lab.entity.dto.LoginResponse;
import edu.miu.waa.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/authenticate")
    LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

}
