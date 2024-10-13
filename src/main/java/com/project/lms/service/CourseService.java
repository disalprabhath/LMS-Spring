package com.project.lms.service;

import com.project.lms.dto.request.ChangeCourseStateDto;
import com.project.lms.dto.request.CourseDTO;
import com.project.lms.entity.Course;

import java.util.List;

public interface CourseService {

    List<CourseDTO> getAllCourses();

    String updateCourse(int id, CourseDTO courseDTO);

    String saveCourse(CourseDTO courseDTO);

    CourseDTO getCourseById(int id);

    ChangeCourseStateDto changeCourseState(int courseId, ChangeCourseStateDto changeCourseStateDto);
}
