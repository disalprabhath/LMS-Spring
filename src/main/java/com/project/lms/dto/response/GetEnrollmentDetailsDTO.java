package com.project.lms.dto.response;

import com.project.lms.entity.enums.CompletionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetEnrollmentDetailsDTO {

    private int EnrollmentId;
    private String student;
    private String course;
    private CompletionStatus completionStatus;


}
