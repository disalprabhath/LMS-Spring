package com.project.lms.service;

import com.project.lms.dto.request.StudentEnrollmentDTO;
import com.project.lms.dto.response.GetEnrollmentDetailsDTO;

import java.util.List;

public interface EnrollmentService {
    String addEnrollemnt(StudentEnrollmentDTO studentEnrollmentDTO);

    String updateEnrollment(int id, StudentEnrollmentDTO studentEnrollmentDTO);

    List<GetEnrollmentDetailsDTO> getAllEnrollementDetails(int page);
}
