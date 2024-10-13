package com.project.lms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EssayTestDTO {

    private Long courseId;
    private String essayQuestion;
    private Integer maxMarks;
}
