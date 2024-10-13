package com.project.lms.entity.tests.results;

import com.project.lms.entity.User;
import com.project.lms.entity.tests.quiz.Question;
import com.project.lms.entity.tests.quiz.Quiz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quiz_results")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private int resultId;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User student;

    @Column(name = "marks")
    private int marks;

    @Column(name = "submission_date", columnDefinition = "DATETIME")
    private Date date;
}
