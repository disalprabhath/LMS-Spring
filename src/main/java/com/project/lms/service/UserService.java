package com.project.lms.service;

import com.project.lms.dto.request.ChangeRoleUserDTO;
import com.project.lms.dto.request.UserDto;
import com.project.lms.dto.response.UserGetDto;
import com.project.lms.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String saveUser(UserDto userDto);

    String updateUserById(int id, UserDto userDto);

    List<UserGetDto> getAllUsers();

    Optional<User> findUserById(int userId);

    User findUserByName(String userName);

    ChangeRoleUserDTO changeUserRole(int userId, ChangeRoleUserDTO changeRoleUserDTO);
}
