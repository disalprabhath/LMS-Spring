package com.project.lms.service.impl;

import com.project.lms.dto.request.StudentEnrollmentDTO;
import com.project.lms.dto.response.GetEnrollmentDetailsDTO;
import com.project.lms.entity.StudentEnrollment;
import com.project.lms.exception.NotFoundException;
import com.project.lms.repository.CourseRepo;
import com.project.lms.repository.EnrollmentRepo;
import com.project.lms.repository.PaymentRepo;
import com.project.lms.repository.UserRepo;
import com.project.lms.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public String updateEnrollment(int id, StudentEnrollmentDTO studentEnrollmentDTO) {
        StudentEnrollment studentEnrollment = enrollmentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found"));
        studentEnrollment.setStudent(userRepo.getReferenceById(studentEnrollmentDTO.getStudent()));
        studentEnrollment.setCourse(courseRepo.getReferenceById(studentEnrollmentDTO.getCourse()));
        studentEnrollment.setDate(studentEnrollmentDTO.getDate());
        studentEnrollment.setPayment(paymentRepo.getReferenceById(studentEnrollmentDTO.getPayment()));
        studentEnrollment.setCompletionStatus(studentEnrollmentDTO.getCompletionStatus());

        enrollmentRepo.save(studentEnrollment);
        return "Enrollment updated successfully";
    }

    @Override
    public List<GetEnrollmentDetailsDTO> getAllEnrollementDetails(int page) {
        int pageSize = 10;
        int offset = page * pageSize;

        return enrollmentRepo.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(enrollment -> new GetEnrollmentDetailsDTO(
                        enrollment.getEnrollmentId(),
                        enrollment.getStudent().getUserId(),
                        enrollment.getCourse().getCourseId(),
                        enrollment.getCompletionStatus()
                ))
                .collect(Collectors.toList());
    }
}
