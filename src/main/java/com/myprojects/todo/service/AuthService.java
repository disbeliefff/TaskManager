package com.myprojects.todo.service;

import com.myprojects.todo.dto.JwtRequest;
import com.myprojects.todo.dto.JwtResponse;

public interface AuthService {

    JwtResponse login (JwtRequest login);

    JwtResponse refresh (String refreshToken);


}
