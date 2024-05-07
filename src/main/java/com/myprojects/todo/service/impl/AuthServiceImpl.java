package com.myprojects.todo.service.impl;

import com.myprojects.todo.domain.user.User;
import com.myprojects.todo.dto.JwtRequest;
import com.myprojects.todo.dto.JwtResponse;
import com.myprojects.todo.service.AuthService;
import com.myprojects.todo.service.UserService;
import com.myprojects.todo.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    @Override
    public JwtResponse login(JwtRequest login) {
        JwtResponse jwtResponse = new JwtResponse();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                (login.getUsername(), login.getPassword())
        );
        User user = userService.getByUsername(login.getUsername());
        jwtResponse.setId(user.getId());
        jwtResponse.setUsername(user.getUsername());
        jwtResponse.setAccessToken(tokenProvider.createAccessToken(user.getId(), user.getUsername(), user.getRoles()));
        jwtResponse.setRefreshToken(tokenProvider.createRefreshToken(user.getId(), user.getUsername()));
        return jwtResponse;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return tokenProvider.refreshUserToken(refreshToken);
    }
}
