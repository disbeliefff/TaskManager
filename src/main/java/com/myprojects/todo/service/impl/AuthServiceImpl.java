package com.myprojects.todo.service.impl;

import com.myprojects.todo.dto.JwtRequest;
import com.myprojects.todo.dto.JwtResponse;
import com.myprojects.todo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public JwtResponse login(JwtRequest login) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
