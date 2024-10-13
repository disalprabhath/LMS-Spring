package com.project.lms.entity;

import com.project.lms.entity.enums.Status;
import com.project.lms.entity.tests.essay.Essay;
import com.project.lms.entity.tests.quiz.Quiz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "course_dec", length = 2000)
    private String courseDec;

    @ManyToOne
    @JoinColumn(name="created_by_user_id", nullable=false)
    private User lecture;

    @Column(name = "created_date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "course_price")
    private double price;


    @Column(name = "status", columnDefinition = "TINYINT(1) default 0")
    private boolean status;

    //for course content
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseContent> courseContents;

    //for course quiz
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Quiz> quizzes;

    //for course essay
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Essay> essays;

    //for student enrollment
    @OneToMany(mappedBy="course")
    private Set<StudentEnrollment> studentEnrollments;

    //for student payment
    @OneToMany(mappedBy="course")
    private Set<Payments> payments;

    public Course(String courseTitle, String courseDec, User lecture, Date date, double price) {
        this.courseTitle = courseTitle;
        this.courseDec = courseDec;
        this.lecture = lecture;
        this.date = date;
        this.price = price;
    }
}
