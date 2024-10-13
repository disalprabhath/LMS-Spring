package com.project.lms.utill.mappers;

import com.project.lms.dto.request.UserDto;
import com.project.lms.dto.response.UserGetDto;
import com.project.lms.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userSaveDtoToUser (UserDto userDto);

    User userUpdateDtoToUser (UserDto userDto);

    List<UserGetDto> usersToUserDtos(List<User> users);

    UserGetDto userToUserGetDto(User user);
}
