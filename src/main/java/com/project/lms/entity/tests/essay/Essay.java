package com.project.lms.entity.tests.essay;

import com.project.lms.entity.Course;
import com.project.lms.entity.CourseContent;
import com.project.lms.entity.tests.quiz.Question;
import com.project.lms.entity.tests.results.EssayResults;
import com.project.lms.entity.tests.results.QuizResults;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "essay")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Essay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int essayTestId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false, length = 2000)
    private String essayQuestion;

    @Column(name = "max_marks",nullable = false)
    private Integer maxMarks;

    @Column(name = "created_date")
    private Date date;

    //for course essay results
    @OneToMany(mappedBy = "essay", cascade = CascadeType.ALL)
    private List<EssayResults> essayResults;
}
