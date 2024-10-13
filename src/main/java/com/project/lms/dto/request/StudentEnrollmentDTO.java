package com.project.lms.dto.request;

import com.project.lms.entity.enums.CompletionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentEnrollmentDTO {

    private int student; // from user

    private int course; // from course

    private Date date;

    private int payment; // from payment

    private CompletionStatus completionStatus;

}
