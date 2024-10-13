package com.project.lms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizResultDTO {

    private Long quizId;
    private Long userId;
    private Integer marksObtained;
}
