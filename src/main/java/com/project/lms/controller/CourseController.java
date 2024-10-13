package com.project.lms.controller;

import com.project.lms.dto.request.ChangeCourseStateDto;
import com.project.lms.dto.request.ChangeRoleUserDTO;
import com.project.lms.dto.request.CourseDTO;
import com.project.lms.service.CourseService;
import com.project.lms.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(path = "/save_course")
    public ResponseEntity<StandardResponse> saveCourse(@RequestBody CourseDTO courseDTO){
        String message= courseService.saveCourse(courseDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "/update_course/{id}")
    public ResponseEntity<StandardResponse> updateCourse(@PathVariable int id, @RequestBody CourseDTO courseDTO){
        String message= courseService.updateCourse(id,courseDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get_all_courses")
    public ResponseEntity<StandardResponse> getAllCourses(){
        List<CourseDTO> courses= courseService.getAllCourses();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", courses),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get_course_by_id/{id}")
    public ResponseEntity<StandardResponse> getCourseById(@PathVariable int id){

        CourseDTO courses=courseService.getCourseById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", courses),
                HttpStatus.OK
        );
    }

    @PutMapping(path = "change-state/{courseId}")
    public ResponseEntity<StandardResponse> changeCourseState(
            @PathVariable int courseId,
            @RequestBody ChangeCourseStateDto changeCourseStateDto)
    {
        ChangeCourseStateDto updatedCourse= courseService.changeCourseState(courseId,changeCourseStateDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Role updated successfully", updatedCourse),
                HttpStatus.OK
        );
    }

}
