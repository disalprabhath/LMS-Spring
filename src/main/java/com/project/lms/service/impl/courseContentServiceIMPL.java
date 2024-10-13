package com.project.lms.service.impl;

import com.project.lms.dto.request.CourseContentDTO;
import com.project.lms.entity.Course;
import com.project.lms.entity.CourseContent;
import com.project.lms.exception.NotFoundException;
import com.project.lms.repository.CourseContentRepo;
import com.project.lms.repository.CourseRepo;
import com.project.lms.repository.UserRepo;
import com.project.lms.service.CourseContentService;
import com.project.lms.utill.mappers.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class courseContentServiceIMPL implements CourseContentService {

    @Autowired
    private CourseContentRepo courseContentRepo;
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private UserRepo userRepo;

    @Override
    @Transactional
    public String createCourseContent(CourseContentDTO courseContentDTO) {

        Course course = courseRepo.findById(courseContentDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        CourseContent courseContent = new CourseContent(
                course,
                courseContentDTO.getContentType(),
                courseContentDTO.getContentTitle(),
                courseContentDTO.getFilePath(),
                courseContentDTO.getDescription()
        );

        courseContentRepo.save(courseContent);
        return "Course content saved successfully";
    }

    @Override
    public String updateContent(int id, CourseContentDTO courseContentDTO) {
        Course course = courseRepo.findById(courseContentDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        CourseContent courseContent = courseContentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Content not found"));

        courseContent.setCourse(course);
        courseContent.setContentType(courseContentDTO.getContentType());
        courseContent.setContentTitle(courseContentDTO.getContentTitle());
        courseContent.setFilePath(courseContentDTO.getFilePath());
        courseContent.setDescription(courseContentDTO.getDescription());

        courseContentRepo.save(courseContent);
        return "Course content updated successfully";
    }

    @Override
    public CourseContentDTO getCourseContentById(int id) {
        CourseContent content=courseContentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Course Content not found with id: " + id));
        return contentMapper.toCourseDTO(content);
    }

    @Override
    public List<CourseContentDTO> getAllCourseContents() {
        List<CourseContent> contents=courseContentRepo.findAll();
        return contents.stream()
                .map(content -> {
                    CourseContentDTO dto = contentMapper.toCourseContentDTO(content);
                    dto.setCourseId(content.getCourse().getCourseId());
                    return dto;
                })
                .collect(Collectors.toList());
    }



}
