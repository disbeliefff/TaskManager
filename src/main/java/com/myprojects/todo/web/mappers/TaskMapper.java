package com.myprojects.todo.web.mappers;

import com.myprojects.todo.domain.task.Task;
import com.myprojects.todo.dto.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto (Task task);

    List<TaskDto> toDto (List<Task> tasks);

    Task toEntity (TaskDto dto);
}
