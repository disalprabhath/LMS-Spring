package com.project.lms.dto.request;

import com.project.lms.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangeRoleUserDTO {

    private Role role;
}
