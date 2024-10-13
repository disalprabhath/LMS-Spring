package com.project.lms.controller;

import com.project.lms.dto.request.ChangeRoleUserDTO;
import com.project.lms.dto.request.UserDto;
import com.project.lms.dto.response.UserGetDto;
import com.project.lms.entity.User;
import com.project.lms.service.UserService;
import com.project.lms.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save_user")
    public ResponseEntity<StandardResponse> saveUser(@RequestBody UserDto userDto){
        String message = userService.saveUser(userDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "/update_user/{id}")
    public ResponseEntity<StandardResponse> updateUser(@PathVariable int id, @RequestBody UserDto userDto){
        String message = userService.updateUserById(id, userDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/get_all_users")
    public ResponseEntity<StandardResponse> getAllUsers() {
        List<UserGetDto> users = userService.getAllUsers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", users),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/find_user_by_id",
            params = "id"
    )
    public ResponseEntity<StandardResponse> findUserById(@RequestParam(value = "id") int userId){

        Optional<User> user=userService.findUserById(userId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", user),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/find_user_by_name",
            params = "userName"
    )
    public ResponseEntity<StandardResponse> findUserByName(@RequestParam(value = "userName") String userName){
        User user = userService.findUserByName(userName);

        if (user == null) {

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(404, "User not found", null),
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", user),
                HttpStatus.OK
        );
    }

    @PutMapping(path = "/users/{userId}/change-role")
    public ResponseEntity<StandardResponse> changeUserRole(
            @PathVariable int userId,
            @RequestBody ChangeRoleUserDTO changeRoleUserDTO)
    {
        ChangeRoleUserDTO updatedUser= userService.changeUserRole(userId,changeRoleUserDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Role updated successfully", updatedUser),
                HttpStatus.OK
        );
    }
}
