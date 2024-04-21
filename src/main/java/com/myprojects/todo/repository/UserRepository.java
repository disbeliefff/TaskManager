package com.myprojects.todo.repository;

import com.myprojects.todo.domain.user.Role;
import com.myprojects.todo.domain.user.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById (Long id);
    Optional<User> findByUsername(String username);

    void update(User user);
    void create (User user);
    void insertUserRole(Role role, Long userId);
    void delete (Long userId);

    boolean isTaskOwner (Long userId, Long taskId);

}
