package com.project.lms.service.impl;

import com.project.lms.dto.request.StudentEnrollmentDTO;
import com.project.lms.entity.StudentEnrollment;
import com.project.lms.entity.enums.CompletionStatus;
import com.project.lms.repository.CourseRepo;
import com.project.lms.repository.EnrollmentRepo;
import com.project.lms.repository.PaymentRepo;
import com.project.lms.repository.UserRepo;
import com.project.lms.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EnrollmentServiceIMPL implements EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public String addEnrollemnt(StudentEnrollmentDTO studentEnrollmentDTO) {
        StudentEnrollment studentEnrollment = new StudentEnrollment(
                userRepo.getReferenceById(studentEnrollmentDTO.getStudent()),
                courseRepo.getReferenceById(studentEnrollmentDTO.getCourse()),
                studentEnrollmentDTO.getDate(),
                paymentRepo.getReferenceById(studentEnrollmentDTO.getPayment()),
                studentEnrollmentDTO.getCompletionStatus()
        );
        enrollmentRepo.save(studentEnrollment);
        return "Saved";
    }
}
