package com.project.lms.controller;

import com.project.lms.dto.request.CourseContentDTO;
import com.project.lms.dto.request.CourseDTO;
import com.project.lms.service.CourseContentService;
import com.project.lms.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/course_content")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @PostMapping(path = "create_content")
    public ResponseEntity<StandardResponse> createContent(@RequestBody CourseContentDTO courseContentDTO){
        String message= courseContentService.createCourseContent(courseContentDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "update_course/{id}")
    public ResponseEntity<StandardResponse> updateContent(@PathVariable int id,@RequestBody CourseContentDTO courseContentDTO){
        String message= courseContentService.updateContent(id,courseContentDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "getAllCourseContents")
    public ResponseEntity<StandardResponse> getAllCourseContents(){
        List<CourseContentDTO> contents= courseContentService.getAllCourseContents();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", contents),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get_course_content_by_id/{id}")
    public ResponseEntity<StandardResponse> getCourseContentById(@PathVariable int id){
        CourseContentDTO contents=courseContentService.getCourseContentById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", contents),
                HttpStatus.OK
        );
    }
}
