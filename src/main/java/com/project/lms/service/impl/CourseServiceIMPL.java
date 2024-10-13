package com.project.lms.service.impl;

import com.project.lms.dto.request.ChangeCourseStateDto;
import com.project.lms.dto.request.CourseDTO;
import com.project.lms.entity.Course;
import com.project.lms.exception.NotFoundException;
import com.project.lms.repository.CourseRepo;
import com.project.lms.repository.UserRepo;
import com.project.lms.service.CourseService;
import com.project.lms.utill.mappers.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceIMPL implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserRepo userRepo;


    @Override
    @Transactional
    public String saveCourse(CourseDTO courseDTO) {
        Course course=new Course(
                courseDTO.getCourseTitle(),
                courseDTO.getCourseDec(),
                userRepo.getReferenceById(courseDTO.getLecture()),
                courseDTO.getDate(),
                courseDTO.getPrice()
        );
        courseRepo.save(course);
        return "Saved";
    }

    @Override
    public String updateCourse(int id, CourseDTO courseDTO) {
        Course course=courseRepo.findById(id)
                .orElseThrow(()-> new NotFoundException("Course not found"));
        course.setCourseTitle(courseDTO.getCourseTitle());
        course.setCourseDec(courseDTO.getCourseDec());
        course.setLecture(userRepo.getReferenceById(courseDTO.getLecture()));
        course.setDate(courseDTO.getDate());
        course.setPrice(courseDTO.getPrice());
        courseRepo.save(course);
        return "Updated";
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses=courseRepo.findAll();
        return courseMapper.toCourseDTOs(courses);
    }

    @Override
    public CourseDTO getCourseById(int id) {
        Course course=courseRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with id: " + id));
        return courseMapper.toCourseDTO(course);
    }

    @Override
    public ChangeCourseStateDto changeCourseState(int courseId, ChangeCourseStateDto changeCourseStateDto) {
        Course course= courseRepo.findById(courseId).orElseThrow(() -> new NotFoundException("Course not found"));
        course.setStatus(changeCourseStateDto.isStatus());
        courseRepo.save(course);
        return new ChangeCourseStateDto(course.isStatus());
    }
}
