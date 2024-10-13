package com.project.lms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizDTO {

    private Long courseId;
    private String title;
    private Integer totalMarks;

}
