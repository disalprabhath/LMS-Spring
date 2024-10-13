package com.project.lms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGetDto {

    private int userId;

    private String userName;

    private String email;

    private ArrayList<String> phoneNumber;

    private String address;
}
