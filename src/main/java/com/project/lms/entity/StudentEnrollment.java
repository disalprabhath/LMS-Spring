package com.project.lms.entity;

import com.project.lms.entity.enums.CompletionStatus;
import com.project.lms.entity.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "studen_enrollment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private int EnrollmentId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "enrollment_date", columnDefinition = "DATETIME")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payments payment;

    @Enumerated(EnumType.STRING)
    @Column(name = "completion_status", nullable = false)
    private CompletionStatus completionStatus;

    public StudentEnrollment(User student, Course course, Date date, Payments payment, CompletionStatus completionStatus) {
        this.student = student;
        this.course = course;
        this.date = date;
        this.payment = payment;
        this.completionStatus = completionStatus;
    }
}
