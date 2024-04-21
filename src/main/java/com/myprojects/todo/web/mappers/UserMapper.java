package com.myprojects.todo.web.mappers;

import com.myprojects.todo.domain.user.User;
import com.myprojects.todo.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity (UserDto dto);
}
