package com.project.lms.service.impl;

import com.project.lms.dto.request.ChangeRoleUserDTO;
import com.project.lms.dto.request.UserDto;
import com.project.lms.dto.response.UserGetDto;
import com.project.lms.entity.User;
import com.project.lms.exception.NotFoundException;
import com.project.lms.repository.UserRepo;
import com.project.lms.service.UserService;
import com.project.lms.utill.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String saveUser(UserDto userDto) {

        User user = userMapper.userSaveDtoToUser(userDto);
        if(!userRepo.existsById(user.getUserId())){
            userRepo.save(user);
            return user.getUserId()+ " user saved";
        }else {
            throw new DuplicateKeyException("Already Added");
        }
    }

    @Override
    public String updateUserById(int id, UserDto userDto) {
        if(userRepo.existsById(id)){
            User existingUser = userRepo.findById(id).orElseThrow();
            userMapper.userUpdateDtoToUser(userDto);
            userRepo.save(existingUser);
            return existingUser.getUserId() + " user updated";
        }else {
            throw new RuntimeException("User  not found");
        }
    }

    @Override
    public List<UserGetDto> getAllUsers() {
        List<User> getAllUsers=userRepo.findAll();
        return userMapper.usersToUserDtos(getAllUsers);

    }

    @Override
    public Optional<User> findUserById(int userId) {
        return userRepo.findById(userId);
    }

    @Override
    public User findUserByName(String userName) {
        return userRepo.findUserByUserName(userName);
    }

    @Override
    public ChangeRoleUserDTO changeUserRole(int userId, ChangeRoleUserDTO changeRoleUserDTO) {
        User user= userRepo.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        user.setRole(changeRoleUserDTO.getRole());
        userRepo.save(user);
        return new ChangeRoleUserDTO(user.getRole());
    }

}
