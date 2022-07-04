package com.pelinhangisi.userauthservice.controller;

import com.pelinhangisi.userauthservice.security.CustomUserDetailService;
import com.pelinhangisi.userauthservice.security.JwtUtil;
import com.pelinhangisi.userauthservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final JwtUtil jwtUtil;

    private final UserService userService;

    private final CustomUserDetailService userDetailService;
}
