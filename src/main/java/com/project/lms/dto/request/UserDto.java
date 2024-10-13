package com.project.lms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String userName;

    private String email;

    private String password;

    private ArrayList<String> phoneNumber;

    private String address;

}
