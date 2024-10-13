package com.project.lms.entity.tests.quiz;

import com.project.lms.entity.Course;
import com.project.lms.entity.CourseContent;
import com.project.lms.entity.tests.essay.Essay;
import com.project.lms.entity.tests.quiz.Question;
import com.project.lms.entity.tests.results.QuizResults;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "quiz")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private int quizId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "title")
    private String title;

    @Column(name = "total_marks")
    private int totalMarks;

    @Column(name = "created_date")
    private Date date;

    //for course quiz questions
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;

    //for course quiz results
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<QuizResults> quizResults;

}
