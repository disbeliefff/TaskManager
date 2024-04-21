package com.myprojects.todo.web.controller;

import com.myprojects.todo.domain.task.Task;
import com.myprojects.todo.domain.user.User;
import com.myprojects.todo.dto.TaskDto;
import com.myprojects.todo.dto.UserDto;
import com.myprojects.todo.dto.validation.OnCreate;
import com.myprojects.todo.dto.validation.OnUpdate;
import com.myprojects.todo.service.TaskService;
import com.myprojects.todo.service.UserService;
import com.myprojects.todo.web.mappers.TaskMapper;
import com.myprojects.todo.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    UserDto getById (@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByUserId (@PathVariable Long id) {
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    public TaskDto createTask (@PathVariable Long id, @Validated(OnCreate.class) @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }

    @PutMapping
    UserDto update (@Validated(OnUpdate.class) @RequestBody UserDto dto){
        User user = userMapper.toEntity(dto);
        userService.update(user);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    void deleteUserById (@PathVariable Long id) {
        userService.delete(id);
    }
}
