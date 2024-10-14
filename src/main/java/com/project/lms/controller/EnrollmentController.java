package com.project.lms.controller;

import com.project.lms.dto.request.StudentEnrollmentDTO;
import com.project.lms.dto.response.GetEnrollmentDetailsDTO;
import com.project.lms.dto.response.PaymentDetailsDto;
import com.project.lms.service.EnrollmentService;
import com.project.lms.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping(path = "update_enrollment/{id}")
    public ResponseEntity<StandardResponse> updateEnrollment(@RequestParam int id, StudentEnrollmentDTO studentEnrollmentDTO){
        String message= enrollmentService.updateEnrollment(id,studentEnrollmentDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }
    @GetMapping(path = "get_all_enrollement_details",
                params = "page")
    public ResponseEntity<StandardResponse> getAllEnrollementDetails(@RequestParam int page){
        List<GetEnrollmentDetailsDTO> enrollmentDetails = enrollmentService.getAllEnrollementDetails(page);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", enrollmentDetails),
                HttpStatus.OK
        );
    }

}
