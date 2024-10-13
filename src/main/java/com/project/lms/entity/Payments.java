package com.project.lms.entity;

import com.project.lms.entity.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private int paymentId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User student;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    @Column(name = "created_date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "amount")
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus = PaymentStatus.Pending;

    //for payment
    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private List<StudentEnrollment> studentEnrollments;
}
