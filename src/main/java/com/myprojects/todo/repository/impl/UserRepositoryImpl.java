package com.myprojects.todo.repository.impl;

import com.myprojects.todo.domain.user.Role;
import com.myprojects.todo.domain.user.User;
import com.myprojects.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void create(User user) {

    }

    @Override
    public void insertUserRole(Role role, Long userId) {

    }

    @Override
    public void delete(Long userId) {

    }

    @Override
    public boolean isTaskOwner(Long userId, Long taskId) {
        return false;
    }
}
