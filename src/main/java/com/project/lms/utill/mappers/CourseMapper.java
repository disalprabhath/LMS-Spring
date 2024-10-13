package com.project.lms.utill.mappers;

import com.project.lms.dto.request.CourseContentDTO;
import com.project.lms.dto.request.CourseDTO;
import com.project.lms.entity.Course;
import com.project.lms.entity.CourseContent;
import com.project.lms.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDTO toCourseDTO(Course course);
    List<CourseDTO> toCourseDTOs(List<Course> courses);

    default int map(User user) {
        return user.getUserId();
    }

}
