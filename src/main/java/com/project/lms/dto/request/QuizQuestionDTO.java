package com.project.lms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizQuestionDTO {

    private int quizId;
    private String questionText;
    private String answerOptions;
    private String correctAnswer;
}
