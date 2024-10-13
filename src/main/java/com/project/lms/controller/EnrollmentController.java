package com.project.lms.controller;

import com.project.lms.dto.request.StudentEnrollmentDTO;
import com.project.lms.service.EnrollmentService;
import com.project.lms.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping(path = "add_enrollment")
    public ResponseEntity<StandardResponse> addEnrollemnt(@RequestBody StudentEnrollmentDTO studentEnrollmentDTO){
        String message = enrollmentService.addEnrollemnt(studentEnrollmentDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

}
