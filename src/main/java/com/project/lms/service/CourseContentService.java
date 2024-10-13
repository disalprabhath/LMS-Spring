package com.project.lms.service;

import com.project.lms.dto.request.CourseContentDTO;

import java.util.List;

public interface CourseContentService {
    String createCourseContent(CourseContentDTO courseContentDTO);

    List<CourseContentDTO> getAllCourseContents();

    String updateContent(int id, CourseContentDTO courseContentDTO);

    CourseContentDTO getCourseContentById(int id);
}
